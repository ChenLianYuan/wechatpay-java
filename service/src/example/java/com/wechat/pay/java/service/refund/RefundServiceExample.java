package com.wechat.pay.java.service.refund;

import com.wechat.pay.java.core.RSAConfig;
import com.wechat.pay.java.core.exception.HttpException;
import com.wechat.pay.java.core.exception.MalformedMessageException;
import com.wechat.pay.java.core.exception.ServiceException;
import com.wechat.pay.java.service.refund.model.CreateRequest;
import com.wechat.pay.java.service.refund.model.QueryByOutRefundNoRequest;
import com.wechat.pay.java.service.refund.model.Refund;

/** RefundService使用示例 */
public class RefundServiceExample {

  public static String merchantId = "";
  public static String privateKeyPath = "";
  public static String merchantSerialNumber = "";
  public static String wechatPayCertificatePath = "";
  public static RefundService service;

  public static void main(String[] args) {
    // 初始化商户配置
    RSAConfig config =
        new RSAConfig.Builder()
            .merchantId(merchantId)
            // 使用 com.wechat.pay.java.core.util 中的函数从本地文件中加载商户私钥，商户私钥会用来生成请求的签名
            .privateKeyFromPath(privateKeyPath)
            .merchantSerialNumber(merchantSerialNumber)
            .wechatPayCertificatesFromPath(wechatPayCertificatePath)
            .build();

    // 初始化服务
    service = new RefundService.Builder().config(config).build();
    // ... 调用接口
    try {
      Refund response = create();
    } catch (HttpException e) { // 发送HTTP请求失败
      // 调用e.getHttpRequest()获取请求打印日志或上报监控，更多方法见HttpException定义
    } catch (ServiceException e) { // 服务返回状态小于200或大于等于300，例如500
      // 调用e.getResponseBody()获取返回体打印日志或上报监控，更多方法见ServiceException定义
    } catch (MalformedMessageException e) { // 服务返回成功，返回体类型不合法，或者解析返回体失败
      // 调用e.getMessage()获取信息打印日志或上报监控，更多方法见MalformedMessageException定义
    }
  }
  /** 退款申请 */
  public static Refund create() {
    CreateRequest request = new CreateRequest();
    // 调用request.setXxx(val)设置所需参数，具体参数可见Request定义
    // 调用接口
    return service.create(request);
  }
  /** 查询单笔退款（通过商户退款单号） */
  public static Refund queryByOutRefundNo() {

    QueryByOutRefundNoRequest request = new QueryByOutRefundNoRequest();
    // 调用request.setXxx(val)设置所需参数，具体参数可见Request定义
    // 调用接口
    return service.queryByOutRefundNo(request);
  }
}
