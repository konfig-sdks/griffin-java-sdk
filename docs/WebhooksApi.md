# WebhooksApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**activateAction**](WebhooksApi.md#activateAction) | **POST** /v0/webhooks/{webhook-id}/actions/activate |  |
| [**createWebhook**](WebhooksApi.md#createWebhook) | **POST** /v0/organizations/{organization-id}/webhooks |  |
| [**deactivateAction**](WebhooksApi.md#deactivateAction) | **POST** /v0/webhooks/{webhook-id}/actions/deactivate |  |
| [**deleteWebhook**](WebhooksApi.md#deleteWebhook) | **DELETE** /v0/webhooks/{webhook-id} |  |
| [**getAll**](WebhooksApi.md#getAll) | **GET** /v0/organizations/{organization-id}/webhooks |  |
| [**getLatestTestStatus**](WebhooksApi.md#getLatestTestStatus) | **GET** /v0/webhooks/{webhook-id}/actions/test |  |
| [**getWebhook**](WebhooksApi.md#getWebhook) | **GET** /v0/webhooks/{webhook-id} |  |
| [**sendTestEvent**](WebhooksApi.md#sendTestEvent) | **POST** /v0/webhooks/{webhook-id}/actions/test |  |
| [**updateWebhook**](WebhooksApi.md#updateWebhook) | **PATCH** /v0/webhooks/{webhook-id} |  |


<a name="activateAction"></a>
# **activateAction**
> WebhooksActivateActionResponse activateAction(webhookId).execute();



Activate a webhook

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhooksApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String webhookId = "webhookId_example";
    try {
      WebhooksActivateActionResponse result = client
              .webhooks
              .activateAction(webhookId)
              .execute();
      System.out.println(result);
      System.out.println(result.getOrganizationUrl());
      System.out.println(result.getWebhookUrl());
      System.out.println(result.getWebhookDestinationUrl());
      System.out.println(result.getTestWebhookUrl());
      System.out.println(result.getActivateWebhookUrl());
      System.out.println(result.getDeactivateWebhookUrl());
      System.out.println(result.getWebhookDescription());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#activateAction");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<WebhooksActivateActionResponse> response = client
              .webhooks
              .activateAction(webhookId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#activateAction");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **webhookId** | **String**|  | |

### Return type

[**WebhooksActivateActionResponse**](WebhooksActivateActionResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

<a name="createWebhook"></a>
# **createWebhook**
> WebhooksCreateWebhookResponse createWebhook(organizationId, webhooksCreateWebhookRequest).execute();



Create a webhook

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhooksApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String webhookDestinationUrl = "webhookDestinationUrl_example"; // The callback URL of the webhook
    String organizationId = "organizationId_example";
    String webhookDescription = "webhookDescription_example"; // A description of the webhook
    try {
      WebhooksCreateWebhookResponse result = client
              .webhooks
              .createWebhook(webhookDestinationUrl, organizationId)
              .webhookDescription(webhookDescription)
              .execute();
      System.out.println(result);
      System.out.println(result.getOrganizationUrl());
      System.out.println(result.getWebhookUrl());
      System.out.println(result.getWebhookDestinationUrl());
      System.out.println(result.getTestWebhookUrl());
      System.out.println(result.getActivateWebhookUrl());
      System.out.println(result.getDeactivateWebhookUrl());
      System.out.println(result.getWebhookDescription());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#createWebhook");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<WebhooksCreateWebhookResponse> response = client
              .webhooks
              .createWebhook(webhookDestinationUrl, organizationId)
              .webhookDescription(webhookDescription)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#createWebhook");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **organizationId** | **String**|  | |
| **webhooksCreateWebhookRequest** | [**WebhooksCreateWebhookRequest**](WebhooksCreateWebhookRequest.md)|  | |

### Return type

[**WebhooksCreateWebhookResponse**](WebhooksCreateWebhookResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The newly-created webhook |  * Location - The URL to check the progress of the test <br>  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **422** |  |  -  |

<a name="deactivateAction"></a>
# **deactivateAction**
> WebhooksDeactivateActionResponse deactivateAction(webhookId).execute();



Deactivate a webhook

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhooksApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String webhookId = "webhookId_example";
    try {
      WebhooksDeactivateActionResponse result = client
              .webhooks
              .deactivateAction(webhookId)
              .execute();
      System.out.println(result);
      System.out.println(result.getOrganizationUrl());
      System.out.println(result.getWebhookUrl());
      System.out.println(result.getWebhookDestinationUrl());
      System.out.println(result.getTestWebhookUrl());
      System.out.println(result.getActivateWebhookUrl());
      System.out.println(result.getDeactivateWebhookUrl());
      System.out.println(result.getWebhookDescription());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#deactivateAction");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<WebhooksDeactivateActionResponse> response = client
              .webhooks
              .deactivateAction(webhookId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#deactivateAction");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **webhookId** | **String**|  | |

### Return type

[**WebhooksDeactivateActionResponse**](WebhooksDeactivateActionResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

<a name="deleteWebhook"></a>
# **deleteWebhook**
> deleteWebhook(webhookId).execute();



Delete a webhook

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhooksApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String webhookId = "webhookId_example";
    try {
      client
              .webhooks
              .deleteWebhook(webhookId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#deleteWebhook");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .webhooks
              .deleteWebhook(webhookId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#deleteWebhook");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **webhookId** | **String**|  | |

### Return type

null (empty response body)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

<a name="getAll"></a>
# **getAll**
> WebhooksGetAllResponse getAll(organizationId).execute();



Get all webhooks for the organization

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhooksApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String organizationId = "organizationId_example";
    try {
      WebhooksGetAllResponse result = client
              .webhooks
              .getAll(organizationId)
              .execute();
      System.out.println(result);
      System.out.println(result.getOrganizationWebhooks());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#getAll");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<WebhooksGetAllResponse> response = client
              .webhooks
              .getAll(organizationId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#getAll");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **organizationId** | **String**|  | |

### Return type

[**WebhooksGetAllResponse**](WebhooksGetAllResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |

<a name="getLatestTestStatus"></a>
# **getLatestTestStatus**
> WebhooksGetLatestTestStatusResponse getLatestTestStatus(webhookId).execute();



Get the status of the latest test event

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhooksApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String webhookId = "webhookId_example";
    try {
      WebhooksGetLatestTestStatusResponse result = client
              .webhooks
              .getLatestTestStatus(webhookId)
              .execute();
      System.out.println(result);
      System.out.println(result.getWebhookRequestStatus());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getWebhookHttpStatus());
      System.out.println(result.getWebhookErrorCode());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#getLatestTestStatus");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<WebhooksGetLatestTestStatusResponse> response = client
              .webhooks
              .getLatestTestStatus(webhookId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#getLatestTestStatus");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **webhookId** | **String**|  | |

### Return type

[**WebhooksGetLatestTestStatusResponse**](WebhooksGetLatestTestStatusResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

<a name="getWebhook"></a>
# **getWebhook**
> WebhooksGetWebhookResponse getWebhook(webhookId).execute();



Fetch a webhook

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhooksApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String webhookId = "webhookId_example";
    try {
      WebhooksGetWebhookResponse result = client
              .webhooks
              .getWebhook(webhookId)
              .execute();
      System.out.println(result);
      System.out.println(result.getOrganizationUrl());
      System.out.println(result.getWebhookUrl());
      System.out.println(result.getWebhookDestinationUrl());
      System.out.println(result.getTestWebhookUrl());
      System.out.println(result.getActivateWebhookUrl());
      System.out.println(result.getDeactivateWebhookUrl());
      System.out.println(result.getWebhookDescription());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#getWebhook");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<WebhooksGetWebhookResponse> response = client
              .webhooks
              .getWebhook(webhookId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#getWebhook");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **webhookId** | **String**|  | |

### Return type

[**WebhooksGetWebhookResponse**](WebhooksGetWebhookResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

<a name="sendTestEvent"></a>
# **sendTestEvent**
> WebhooksSendTestEventResponse sendTestEvent(webhookId).execute();



Send a test event to the webhook

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhooksApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String webhookId = "webhookId_example";
    try {
      WebhooksSendTestEventResponse result = client
              .webhooks
              .sendTestEvent(webhookId)
              .execute();
      System.out.println(result);
      System.out.println(result.getWebhookRequestStatus());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getWebhookHttpStatus());
      System.out.println(result.getWebhookErrorCode());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#sendTestEvent");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<WebhooksSendTestEventResponse> response = client
              .webhooks
              .sendTestEvent(webhookId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#sendTestEvent");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **webhookId** | **String**|  | |

### Return type

[**WebhooksSendTestEventResponse**](WebhooksSendTestEventResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  * Location - The URL to check the progress of the test <br>  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **409** | An existing test is in-flight |  -  |

<a name="updateWebhook"></a>
# **updateWebhook**
> WebhooksUpdateWebhookResponse updateWebhook(webhookId, webhooksUpdateWebhookRequest).execute();



Update a webhook

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhooksApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String webhookId = "webhookId_example";
    String webhookDescription = "webhookDescription_example"; // A description of the webhook
    try {
      WebhooksUpdateWebhookResponse result = client
              .webhooks
              .updateWebhook(webhookId)
              .webhookDescription(webhookDescription)
              .execute();
      System.out.println(result);
      System.out.println(result.getOrganizationUrl());
      System.out.println(result.getWebhookUrl());
      System.out.println(result.getWebhookDestinationUrl());
      System.out.println(result.getTestWebhookUrl());
      System.out.println(result.getActivateWebhookUrl());
      System.out.println(result.getDeactivateWebhookUrl());
      System.out.println(result.getWebhookDescription());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#updateWebhook");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<WebhooksUpdateWebhookResponse> response = client
              .webhooks
              .updateWebhook(webhookId)
              .webhookDescription(webhookDescription)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#updateWebhook");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **webhookId** | **String**|  | |
| **webhooksUpdateWebhookRequest** | [**WebhooksUpdateWebhookRequest**](WebhooksUpdateWebhookRequest.md)|  | |

### Return type

[**WebhooksUpdateWebhookResponse**](WebhooksUpdateWebhookResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

