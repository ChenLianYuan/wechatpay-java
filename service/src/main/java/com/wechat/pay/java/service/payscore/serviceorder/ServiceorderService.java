// Copyright 2021 Tencent Inc. All rights reserved.
//
// 支付分对外API
//
// 包含通用化api及先享后付api
//
// API version: 1.6.3

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.payscore.serviceorder;

import static com.wechat.pay.java.core.http.UrlEncoder.urlEncode;
import static java.util.Objects.requireNonNull;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.exception.HttpException;
import com.wechat.pay.java.core.exception.MalformedMessageException;
import com.wechat.pay.java.core.exception.ServiceException;
import com.wechat.pay.java.core.exception.ValidationException;
import com.wechat.pay.java.core.http.Constant;
import com.wechat.pay.java.core.http.DefaultHttpClientBuilder;
import com.wechat.pay.java.core.http.HttpClient;
import com.wechat.pay.java.core.http.HttpHeaders;
import com.wechat.pay.java.core.http.HttpMethod;
import com.wechat.pay.java.core.http.HttpRequest;
import com.wechat.pay.java.core.http.HttpResponse;
import com.wechat.pay.java.core.http.JsonRequestBody;
import com.wechat.pay.java.core.http.MediaType;
import com.wechat.pay.java.service.payscore.serviceorder.model.CancelServiceOrderRequest;
import com.wechat.pay.java.service.payscore.serviceorder.model.CancelServiceOrderResponse;
import com.wechat.pay.java.service.payscore.serviceorder.model.CollectServiceOrderRequest;
import com.wechat.pay.java.service.payscore.serviceorder.model.CollectServiceOrderResponse;
import com.wechat.pay.java.service.payscore.serviceorder.model.CompleteServiceOrderRequest;
import com.wechat.pay.java.service.payscore.serviceorder.model.CompleteServiceOrderResponse;
import com.wechat.pay.java.service.payscore.serviceorder.model.CreateServiceOrderRequest;
import com.wechat.pay.java.service.payscore.serviceorder.model.CreateServiceOrderResponse;
import com.wechat.pay.java.service.payscore.serviceorder.model.DirectCompleteServiceOrderRequest;
import com.wechat.pay.java.service.payscore.serviceorder.model.DirectCompleteServiceOrderResponse;
import com.wechat.pay.java.service.payscore.serviceorder.model.GetServiceOrderRequest;
import com.wechat.pay.java.service.payscore.serviceorder.model.ModifyServiceOrderRequest;
import com.wechat.pay.java.service.payscore.serviceorder.model.ServiceOrderEntity;
import com.wechat.pay.java.service.payscore.serviceorder.model.SyncServiceOrderRequest;

/** ServiceorderService服务 */
public class ServiceorderService {

  private final HttpClient httpClient;

  public ServiceorderService(Config config) {
    this.httpClient =
        new DefaultHttpClientBuilder()
            .credential(requireNonNull(config.createCredential()))
            .validator(requireNonNull(config.createValidator()))
            .build();
  }

  public ServiceorderService(HttpClient httpClient) {
    this.httpClient = requireNonNull(httpClient);
  }

  /**
   * 取消
   *
   * @param request 请求参数
   * @return CancelServiceOrderResponse
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws MalformedMessageException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public CancelServiceOrderResponse cancelServiceOrder(CancelServiceOrderRequest request) {
    String requestPath =
        "https://api.mch.weixin.qq.com/payscore/serviceorder/{out_order_no}/cancel";
    // 添加 path param
    requestPath =
        requestPath.replace("{" + "out_order_no" + "}", urlEncode(request.getOutOrderNo()));
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.POST)
            .url(requestPath)
            .headers(headers)
            .body(new JsonRequestBody.Builder().body(request.toString()).build())
            .build();
    HttpResponse<CancelServiceOrderResponse> httpResponse =
        httpClient.execute(httpRequest, CancelServiceOrderResponse.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 收款
   *
   * @param request 请求参数
   * @return CollectServiceOrderResponse
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws MalformedMessageException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public CollectServiceOrderResponse collectServiceOrder(CollectServiceOrderRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/payscore/serviceorder/{out_order_no}/pay";
    // 添加 path param
    requestPath =
        requestPath.replace("{" + "out_order_no" + "}", urlEncode(request.getOutOrderNo()));
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.POST)
            .url(requestPath)
            .headers(headers)
            .body(new JsonRequestBody.Builder().body(request.toString()).build())
            .build();
    HttpResponse<CollectServiceOrderResponse> httpResponse =
        httpClient.execute(httpRequest, CollectServiceOrderResponse.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 完结
   *
   * @param request 请求参数
   * @return CompleteServiceOrderResponse
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws MalformedMessageException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public CompleteServiceOrderResponse completeServiceOrder(CompleteServiceOrderRequest request) {
    String requestPath =
        "https://api.mch.weixin.qq.com/payscore/serviceorder/{out_order_no}/complete";
    // 添加 path param
    requestPath =
        requestPath.replace("{" + "out_order_no" + "}", urlEncode(request.getOutOrderNo()));
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.POST)
            .url(requestPath)
            .headers(headers)
            .body(new JsonRequestBody.Builder().body(request.toString()).build())
            .build();
    HttpResponse<CompleteServiceOrderResponse> httpResponse =
        httpClient.execute(httpRequest, CompleteServiceOrderResponse.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 创建
   *
   * @param request 请求参数
   * @return CreateServiceOrderResponse
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws MalformedMessageException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public CreateServiceOrderResponse createServiceOrder(CreateServiceOrderRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/payscore/serviceorder";
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.POST)
            .url(requestPath)
            .headers(headers)
            .body(new JsonRequestBody.Builder().body(request.toString()).build())
            .build();
    HttpResponse<CreateServiceOrderResponse> httpResponse =
        httpClient.execute(httpRequest, CreateServiceOrderResponse.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 创单结单合并接口
   *
   * @param request 请求参数
   * @return DirectCompleteServiceOrderResponse
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws MalformedMessageException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public DirectCompleteServiceOrderResponse directCompleteServiceOrder(
      DirectCompleteServiceOrderRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/payscore/serviceorder/direct-complete";
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.POST)
            .url(requestPath)
            .headers(headers)
            .body(new JsonRequestBody.Builder().body(request.toString()).build())
            .build();
    HttpResponse<DirectCompleteServiceOrderResponse> httpResponse =
        httpClient.execute(httpRequest, DirectCompleteServiceOrderResponse.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 查询
   *
   * @param request 请求参数
   * @return ServiceOrderEntity
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws MalformedMessageException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public ServiceOrderEntity getServiceOrder(GetServiceOrderRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/payscore/serviceorder";
    // 添加 query param
    if (request.getOutOrderNo() != null) {
      requestPath += "?out_order_no=" + urlEncode(request.getOutOrderNo());
    }
    if (request.getServiceId() != null) {
      requestPath += "?service_id=" + urlEncode(request.getServiceId());
    }
    if (request.getAppid() != null) {
      requestPath += "?appid=" + urlEncode(request.getAppid());
    }
    if (request.getQueryId() != null) {
      requestPath += "?query_id=" + urlEncode(request.getQueryId());
    }
    if (request.getMchid() != null) {
      requestPath += "?mchid=" + urlEncode(request.getMchid());
    }
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.GET)
            .url(requestPath)
            .headers(headers)
            .build();
    HttpResponse<ServiceOrderEntity> httpResponse =
        httpClient.execute(httpRequest, ServiceOrderEntity.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 修改金额
   *
   * @param request 请求参数
   * @return ServiceOrderEntity
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws MalformedMessageException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public ServiceOrderEntity modifyServiceOrder(ModifyServiceOrderRequest request) {
    String requestPath =
        "https://api.mch.weixin.qq.com/payscore/serviceorder/{out_order_no}/modify";
    // 添加 path param
    requestPath =
        requestPath.replace("{" + "out_order_no" + "}", urlEncode(request.getOutOrderNo()));
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.POST)
            .url(requestPath)
            .headers(headers)
            .body(new JsonRequestBody.Builder().body(request.toString()).build())
            .build();
    HttpResponse<ServiceOrderEntity> httpResponse =
        httpClient.execute(httpRequest, ServiceOrderEntity.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 同步服务订单信息
   *
   * @param request 请求参数
   * @return ServiceOrderEntity
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws MalformedMessageException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public ServiceOrderEntity syncServiceOrder(SyncServiceOrderRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/payscore/serviceorder/{out_order_no}/sync";
    // 添加 path param
    requestPath =
        requestPath.replace("{" + "out_order_no" + "}", urlEncode(request.getOutOrderNo()));
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.POST)
            .url(requestPath)
            .headers(headers)
            .body(new JsonRequestBody.Builder().body(request.toString()).build())
            .build();
    HttpResponse<ServiceOrderEntity> httpResponse =
        httpClient.execute(httpRequest, ServiceOrderEntity.class);
    return httpResponse.getServiceResponse();
  }
}
