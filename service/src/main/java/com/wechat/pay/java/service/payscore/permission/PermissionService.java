// Copyright 2021 Tencent Inc. All rights reserved.
//
// 支付分授权对外API
//
// 支付分授权领域对外API
//
// API version: 1.4.0

// Code generated by WechatPay APIv3 Generator based on [OpenAPI
// Generator](https://openapi-generator.tech); DO NOT EDIT.

package com.wechat.pay.java.service.payscore.permission;

import static com.wechat.pay.java.core.http.UrlEncoder.urlEncode;
import static java.util.Objects.requireNonNull;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.exception.HttpException;
import com.wechat.pay.java.core.exception.ParseException;
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
import com.wechat.pay.java.service.payscore.permission.model.ApplyPermissionsRequest;
import com.wechat.pay.java.service.payscore.permission.model.ApplyPermissionsResponse;
import com.wechat.pay.java.service.payscore.permission.model.GetPermissionsByAuthorizationCodeRequest;
import com.wechat.pay.java.service.payscore.permission.model.GetPermissionsByOpenIdRequest;
import com.wechat.pay.java.service.payscore.permission.model.OrderSceneApplyPermissionsRequest;
import com.wechat.pay.java.service.payscore.permission.model.OrderSceneApplyPermissionsResponse;
import com.wechat.pay.java.service.payscore.permission.model.PermissionsEntity;
import com.wechat.pay.java.service.payscore.permission.model.SceneApplyPermissionsRequest;
import com.wechat.pay.java.service.payscore.permission.model.SceneApplyPermissionsResponse;
import com.wechat.pay.java.service.payscore.permission.model.TerminatePermissionsByCodeRequest;
import com.wechat.pay.java.service.payscore.permission.model.TerminatePermissionsByOpenIdRequest;
import com.wechat.pay.java.service.payscore.permission.model.UpgradeUserPermissionsRequest;

/** PermissionService服务 */
public class PermissionService {

  private final HttpClient httpClient;

  public PermissionService(Config config) {
    this.httpClient =
        new DefaultHttpClientBuilder()
            .credential(requireNonNull(config.createCredential()))
            .validator(requireNonNull(config.createValidator()))
            .build();
  }

  public PermissionService(HttpClient httpClient) {
    this.httpClient = requireNonNull(httpClient);
  }

  /**
   * 商户预授权
   *
   * @param request 请求参数
   * @return ApplyPermissionsResponse
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws ParseException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public ApplyPermissionsResponse applyPermissions(ApplyPermissionsRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/v3/payscore/permissions";
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
    HttpResponse<ApplyPermissionsResponse> httpResponse =
        httpClient.execute(httpRequest, ApplyPermissionsResponse.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 商户查询与用户的授权记录
   *
   * @param request 请求参数
   * @return PermissionsEntity
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws ParseException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public PermissionsEntity getPermissionsByAuthorizationCode(
      GetPermissionsByAuthorizationCodeRequest request) {
    String requestPath =
        "https://api.mch.weixin.qq.com/v3/payscore/permissions/authorization-code/{authorization_code}";
    // 添加 path param
    requestPath =
        requestPath.replace(
            "{" + "authorization_code" + "}", urlEncode(request.getAuthorizationCode()));
    // 添加 query param
    if (request.getServiceId() != null) {
      requestPath += "?service_id=" + urlEncode(request.getServiceId());
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
    HttpResponse<PermissionsEntity> httpResponse =
        httpClient.execute(httpRequest, PermissionsEntity.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 商户查询与用户授权记录
   *
   * @param request 请求参数
   * @return PermissionsEntity
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws ParseException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public PermissionsEntity getPermissionsByOpenId(GetPermissionsByOpenIdRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/v3/payscore/permissions/openid/{openid}";
    // 添加 path param
    requestPath = requestPath.replace("{" + "openid" + "}", urlEncode(request.getOpenid()));
    // 添加 query param
    if (request.getServiceId() != null) {
      requestPath += "?service_id=" + urlEncode(request.getServiceId());
    }
    if (request.getAppid() != null) {
      requestPath += "?appid=" + urlEncode(request.getAppid());
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
    HttpResponse<PermissionsEntity> httpResponse =
        httpClient.execute(httpRequest, PermissionsEntity.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 商户交易场景预授权
   *
   * @param request 请求参数
   * @return OrderSceneApplyPermissionsResponse
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws ParseException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public OrderSceneApplyPermissionsResponse orderSceneApplyPermissions(
      OrderSceneApplyPermissionsRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/v3/payscore/permissions/order-scene";
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
    HttpResponse<OrderSceneApplyPermissionsResponse> httpResponse =
        httpClient.execute(httpRequest, OrderSceneApplyPermissionsResponse.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 商户场景中预授权
   *
   * @param request 请求参数
   * @return SceneApplyPermissionsResponse
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws ParseException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public SceneApplyPermissionsResponse sceneApplyPermissions(SceneApplyPermissionsRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/v3/payscore/permissions/apply-for-scene";
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
    HttpResponse<SceneApplyPermissionsResponse> httpResponse =
        httpClient.execute(httpRequest, SceneApplyPermissionsResponse.class);
    return httpResponse.getServiceResponse();
  }
  /**
   * 商户解除用户授权关系
   *
   * @param request 请求参数
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws ParseException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public void terminatePermissionsByCode(TerminatePermissionsByCodeRequest request) {
    String requestPath =
        "https://api.mch.weixin.qq.com/v3/payscore/permissions/authorization-code/{authorization_code}/terminate";
    // 添加 path param
    requestPath =
        requestPath.replace(
            "{" + "authorization_code" + "}", urlEncode(request.getAuthorizationCode()));
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
    httpClient.execute(httpRequest, null);
  }
  /**
   * 商户解除用户授权关系
   *
   * @param request 请求参数
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws ParseException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public void terminatePermissionsByOpenId(TerminatePermissionsByOpenIdRequest request) {
    String requestPath =
        "https://api.mch.weixin.qq.com/v3/payscore/permissions/openid/{openid}/terminate";
    // 添加 path param
    requestPath = requestPath.replace("{" + "openid" + "}", urlEncode(request.getOpenid()));
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
    httpClient.execute(httpRequest, null);
  }
  /**
   * 商户升级用户服务授权
   *
   * @param request 请求参数
   * @return PermissionsEntity
   * @throws HttpException 发送HTTP请求失败。例如构建请求参数失败、发送请求失败、I/O错误等。包含请求信息。
   * @throws ValidationException 发送HTTP请求成功，验证微信支付返回签名失败。
   * @throws ServiceException 发送HTTP请求成功，服务返回异常。例如返回状态码小于200或大于等于300。
   * @throws ParseException 服务返回成功，content-type不为application/json、解析返回体失败。
   */
  public PermissionsEntity upgradeUserPermissions(UpgradeUserPermissionsRequest request) {
    String requestPath = "https://api.mch.weixin.qq.com/v3/payscore/permissions/openid/{openid}";
    // 添加 path param
    requestPath = requestPath.replace("{" + "openid" + "}", urlEncode(request.getOpenid()));
    HttpHeaders headers = new HttpHeaders();
    headers.addHeader(Constant.ACCEPT, MediaType.APPLICATION_JSON.getValue());
    headers.addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue());
    HttpRequest httpRequest =
        new HttpRequest.Builder()
            .httpMethod(HttpMethod.PATCH)
            .url(requestPath)
            .headers(headers)
            .body(new JsonRequestBody.Builder().body(request.toString()).build())
            .build();
    HttpResponse<PermissionsEntity> httpResponse =
        httpClient.execute(httpRequest, PermissionsEntity.class);
    return httpResponse.getServiceResponse();
  }
}
