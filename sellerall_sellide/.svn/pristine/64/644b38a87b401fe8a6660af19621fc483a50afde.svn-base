package kr.co.sellerall.cmm.config.auth.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if(registrationId.equals("naver")) {
            return ofNaver("id", attributes);
        } else if(registrationId.equals("kakao")) {
        	return ofKakao(userNameAttributeName, attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }
    
    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
    	Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");
    	Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");
    	
    	return OAuthAttributes.builder()
                .name((String) profile.get("nickname"))
                .email((String) kakao_account.get("email"))
                .picture((String) profile.get("profile_image_url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .picture((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
    
    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
    	return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public TbUserInfo toEntity() {
        return TbUserInfo.builder()
                .userName(name)
                .userEmail(email)
                .userPicture(picture)
                .role(Role.GUEST)
                .crtName(name)
                .uptName(name)
                /*.loginDt(LocalDateTime.now())*/
                .build();
    }
}