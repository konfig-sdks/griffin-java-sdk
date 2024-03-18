# OrganizationsApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getDetails**](OrganizationsApi.md#getDetails) | **GET** /v0/organizations/{organization-id} | Get organization |


<a name="getDetails"></a>
# **getDetails**
> OrganizationsGetDetailsResponse getDetails(organizationId).execute();

Get organization

Yields the organization details

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrganizationsApi;
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
      OrganizationsGetDetailsResponse result = client
              .organizations
              .getDetails(organizationId)
              .execute();
      System.out.println(result);
      System.out.println(result.getOwnLegalPersonUrl());
      System.out.println(result.getOrganizationMode());
      System.out.println(result.getOrganizationMembershipsUrl());
      System.out.println(result.getOrganizationInvitationsUrl());
      System.out.println(result.getOrganizationOnboardingApplicationsUrl());
      System.out.println(result.getDisplayName());
      System.out.println(result.getOrganizationApiKeysUrl());
      System.out.println(result.getOrganizationLiveAccessUrl());
      System.out.println(result.getOrganizationWebhooksUrl());
      System.out.println(result.getOrganizationWorkflowsUrl());
      System.out.println(result.getOrganizationBankAccountsUrl());
      System.out.println(result.getAvailableRoles());
      System.out.println(result.getOrganizationUrl());
      System.out.println(result.getOrganizationIndividualsUrl());
      System.out.println(result.getOrganizationCorporationsUrl());
      System.out.println(result.getOrganizationLegalPersonsUrl());
      System.out.println(result.getOrganizationEventsUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrganizationsApi#getDetails");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<OrganizationsGetDetailsResponse> response = client
              .organizations
              .getDetails(organizationId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrganizationsApi#getDetails");
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

[**OrganizationsGetDetailsResponse**](OrganizationsGetDetailsResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Location - The URL to check the progress of the test <br>  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

