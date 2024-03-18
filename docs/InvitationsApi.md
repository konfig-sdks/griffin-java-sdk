# InvitationsApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sendEmail**](InvitationsApi.md#sendEmail) | **POST** /v0/organizations/{organization-id}/invitations | Create invitation |


<a name="sendEmail"></a>
# **sendEmail**
> sendEmail(organizationId, invitationsSendEmailRequest).execute();

Create invitation

&#x60;POST&#x60; creates a new invitation to the organization.  Sends an email invitation to join the &#x60;organization&#x60; to the specified &#x60;email-address&#x60;.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.InvitationsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    Object emailAddress = null;
    String organizationId = "organizationId_example";
    try {
      client
              .invitations
              .sendEmail(emailAddress, organizationId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling InvitationsApi#sendEmail");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .invitations
              .sendEmail(emailAddress, organizationId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling InvitationsApi#sendEmail");
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
| **invitationsSendEmailRequest** | [**InvitationsSendEmailRequest**](InvitationsSendEmailRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |
| **409** |  |  -  |
| **422** |  |  -  |

