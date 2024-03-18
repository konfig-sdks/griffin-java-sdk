# RelianceOnboardingApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createApplication**](RelianceOnboardingApi.md#createApplication) | **POST** /v0/organizations/{organization-id}/onboarding/applications | Create an onboarding application |
| [**getApplication**](RelianceOnboardingApi.md#getApplication) | **GET** /v0/onboarding/applications/{onboarding-application-id} | Get onboarding application |


<a name="createApplication"></a>
# **createApplication**
> RelianceOnboardingCreateApplicationResponse createApplication(organizationId, relianceOnboardingCreateApplicationRequest).execute();

Create an onboarding application

Create an onboarding application and submit it for processing.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.RelianceOnboardingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String workflowUrl = "workflowUrl_example"; // A link to the [workflow](http://docs.griffin.com).
    SubjectProfileProperty subjectProfile = new SubjectProfileProperty();
    String organizationId = "organizationId_example";
    List<RelatedProfile> relatedProfiles = Arrays.asList(); // A list profiles related to the subject (e.g. directors, person with significant control).
    try {
      RelianceOnboardingCreateApplicationResponse result = client
              .relianceOnboarding
              .createApplication(workflowUrl, subjectProfile, organizationId)
              .relatedProfiles(relatedProfiles)
              .execute();
      System.out.println(result);
      System.out.println(result.getOnboardingApplicationUrl());
      System.out.println(result.getOnboardingApplicationStatus());
    } catch (ApiException e) {
      System.err.println("Exception when calling RelianceOnboardingApi#createApplication");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<RelianceOnboardingCreateApplicationResponse> response = client
              .relianceOnboarding
              .createApplication(workflowUrl, subjectProfile, organizationId)
              .relatedProfiles(relatedProfiles)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling RelianceOnboardingApi#createApplication");
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
| **relianceOnboardingCreateApplicationRequest** | [**RelianceOnboardingCreateApplicationRequest**](RelianceOnboardingCreateApplicationRequest.md)|  | |

### Return type

[**RelianceOnboardingCreateApplicationResponse**](RelianceOnboardingCreateApplicationResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The created application |  * Location - The URL to check the progress of the test <br>  |
| **400** | Responds with bad-request if the body does not conform to the schema. |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |
| **422** |  |  -  |

<a name="getApplication"></a>
# **getApplication**
> RelianceOnboardingGetApplicationResponse getApplication(onboardingApplicationId).execute();

Get onboarding application

Fetch an onboarding application.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.RelianceOnboardingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String onboardingApplicationId = "onboardingApplicationId_example";
    try {
      RelianceOnboardingGetApplicationResponse result = client
              .relianceOnboarding
              .getApplication(onboardingApplicationId)
              .execute();
      System.out.println(result);
      System.out.println(result.getOnboardingApplicationUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getWorkflowUrl());
      System.out.println(result.getLegalPersonUrl());
      System.out.println(result.getVerificationUrl());
      System.out.println(result.getOnboardingApplicationStatus());
      System.out.println(result.getDecisionOutcome());
    } catch (ApiException e) {
      System.err.println("Exception when calling RelianceOnboardingApi#getApplication");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<RelianceOnboardingGetApplicationResponse> response = client
              .relianceOnboarding
              .getApplication(onboardingApplicationId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling RelianceOnboardingApi#getApplication");
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
| **onboardingApplicationId** | **String**|  | |

### Return type

[**RelianceOnboardingGetApplicationResponse**](RelianceOnboardingGetApplicationResponse.md)

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

