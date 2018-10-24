package com.yq.blueray.config.mvc;

import com.yq.blueray.extend.security.TestFilterSecurityInterceptor;
import com.yq.blueray.extend.security.UrlAccessDecisionManager;
import com.yq.blueray.extend.security.UrlFilterSecurityInterceptor;
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
 * @Description: 安全配置
 */
@Configuration
public class SecurityConfig {

    /**
     * 配置资源决策器
     * @return
     */
    public UrlAccessDecisionManager getUrlAccessDecisionManager(){
        List<AccessDecisionVoter<? extends Object>> voters = new LinkedList<>();
        voters.add(new MethodVoter());
        voters.add(new UrlVoter());
        return new UrlAccessDecisionManager(voters);
    }

    /**
     *
     * 定义资源角色授权器
     *
     * @return
     */
    public UrlMetadataSourceService getUrlMetadataSourceService(){
        return new UrlMetadataSourceService();
    }

    /**
     * 定义授权拦截器
     *
     * @return
     */
    @Bean
    public TestFilterSecurityInterceptor getTestFilterSecurityInterceptor(){
        TestFilterSecurityInterceptor testFilterSecurityInterceptor = new TestFilterSecurityInterceptor();
        testFilterSecurityInterceptor.setUrlAccessDecisionManager(getUrlAccessDecisionManager());
        testFilterSecurityInterceptor.setSecurityMetadataSource(getUrlMetadataSourceService());
        return testFilterSecurityInterceptor;
    }

    /**
     * 定义授权拦截器
     *
     * @return
     */
    @Bean
    public UrlFilterSecurityInterceptor getUrlFilterSecurityInterceptor(){
        UrlFilterSecurityInterceptor urlFilterSecurityInterceptor = new UrlFilterSecurityInterceptor();
        urlFilterSecurityInterceptor.setUrlAccessDecisionManager(getUrlAccessDecisionManager());
        urlFilterSecurityInterceptor.setSecurityMetadataSource(getUrlMetadataSourceService());
        return urlFilterSecurityInterceptor;
    }


}
