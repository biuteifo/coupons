package com.alex.ali.sms;

import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author AlexBob
 */
public class SmsOnly {

    private List<String> phoneNumbers;
    private String signName;
    private String templateCode;
    private Map templateParam;

    /**
     * 短信发送自定义模板
     *
     * @param phoneNumbers  要发送的手机
     * @param signName      短信签名
     * @param templateCode  短信模板codeId,具体查询ALI服务通过的短信
     * @param templateParam 短信变量填充(code)
     */
    private SmsOnly(List<String> phoneNumbers, String signName, String templateCode, Map templateParam) {

        Assert.isTrue(!StringUtils.isEmpty(phoneNumbers), "phoneNumbers cannot be null");
        Assert.isTrue(!StringUtils.isEmpty(signName), "signName cannot be null");
        Assert.isTrue(!StringUtils.isEmpty(templateCode), "templateCode cannot be null");
        Assert.isTrue(!ObjectUtils.isEmpty(templateParam), "templateParam cannot be null");

        this.phoneNumbers = phoneNumbers;
        this.signName = signName;
        this.templateCode = templateCode;
        this.templateParam = templateParam;
    }



    public static SmsOnly of(List<String> phoneNumbers, String signName, String templateCode, Map templateParam) {
        return new SmsOnly(phoneNumbers,signName,templateCode, templateParam);
    }



    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public Map getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(Map templateParam) {
        this.templateParam = templateParam;
    }
}