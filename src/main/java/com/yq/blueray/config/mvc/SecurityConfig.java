package com.yq.blueray.config.mvc;

import com.yq.blueray.extend.security.UrlAccessDecisionManager;
import com.yq.blueray.extend.security.UrlMetadataSourceService;
import com.yq.blueray.extend.security.voter.MethodVoter;
import com.yq.blueray.extend.security.voter.UrlVoter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: yq
 * @Date: 2018-10-18 17:28
 * @Description:
 */
@Configuration
public class SecurityConfig {

    @Bean
    public UrlAccessDecisionManager getUrlAccessDecisionManager(){
        List<AccessDecisionVoter<? extends Object>> voters = new LinkedList<>();
        voters.add(new MethodVoter());
        voters.add(new UrlVoter());
        return new UrlAccessDecisionManager(voters);
    }

    @Bean
    public UrlMetadataSourceService getUrlMetadataSourceService(){
        return new UrlMetadataSourceService();
    }
}
