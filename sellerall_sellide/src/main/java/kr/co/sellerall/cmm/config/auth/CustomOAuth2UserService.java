package kr.co.sellerall.cmm.config.auth;

import java.time.LocalDateTime;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import kr.co.sellerall.cmm.config.auth.dto.OAuthAttributes;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import kr.co.sellerall.cmm.domain.user.TbUserInfoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService  implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
    private final TbUserInfoRepository userRepository;
    private final HttpSession httpSession;
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException  {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);
        
        //현재 진행중인 서비스를 구분하기 위해 문자열로 받음
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        // OAuth2 로그인 시 키 값이 된다. 구글은 키 값이  "sub" 이고, 네이버는 "response"이고, 카카오는 "id" 이다. 각각 다르므로 이렇게 따로 변수로 받아서 넣어줘야함
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();
        //OAuth2 로그인을 통해 가져온 OAuth2User의 attribute를 담아주는 of 메소드
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        TbUserInfo user = saveOrUpdate(attributes);
		
       /* httpSession.setMaxInactiveInterval(30*60);*/
        httpSession.setAttribute("user", new SessionUser(user));
        
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

    private TbUserInfo saveOrUpdate(OAuthAttributes attributes) {
    	TbUserInfo user = userRepository.findByUserEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture(),LocalDateTime.now()))
                .orElse(attributes.toEntity());
    			/*.orElseThrow(()-> new IllegalArgumentException("sellerall에 해당 ID 가입된 정보가  없습니다."));*/
                /*.orElse(null);*/
    	
    	
        return userRepository.save(user);
    }
}