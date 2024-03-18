# VerificationsApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getVerification**](VerificationsApi.md#getVerification) | **GET** /v0/verifications/{verification-id} | Get verification |
| [**initiateVerification**](VerificationsApi.md#initiateVerification) | **POST** /v0/legal-persons/{legal-person-id}/verifications | Perform verification of a legal person |
| [**listForLegalPerson**](VerificationsApi.md#listForLegalPerson) | **GET** /v0/legal-persons/{legal-person-id}/verifications | List verifications for a legal person |


<a name="getVerification"></a>
# **getVerification**
> VerificationsGetVerificationResponse getVerification(verificationId).execute();

Get verification

Fetch the verification.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.VerificationsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String verificationId = "verificationId_example";
    try {
      VerificationsGetVerificationResponse result = client
              .verifications
              .getVerification(verificationId)
              .execute();
      System.out.println(result);
      System.out.println(result.getVerificationUrl());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getLegalPersonUrl());
      System.out.println(result.getWorkflowUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getVerificationChecksUrl());
      System.out.println(result.getRiskRating());
      System.out.println(result.getVerificationStatus());
      System.out.println(result.getVerificationRiskAssessmentsUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling VerificationsApi#getVerification");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<VerificationsGetVerificationResponse> response = client
              .verifications
              .getVerification(verificationId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling VerificationsApi#getVerification");
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
| **verificationId** | **String**|  | |

### Return type

[**VerificationsGetVerificationResponse**](VerificationsGetVerificationResponse.md)

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
| **404** |  |  -  |

<a name="initiateVerification"></a>
# **initiateVerification**
> VerificationsInitiateVerificationResponse initiateVerification(legalPersonId, verificationsInitiateVerificationRequest).execute();

Perform verification of a legal person

Initiates verification of the subject legal person.  The request body must include a &#x60;workflow-url&#x60; to determine checks to be performed by the verification. The workflow specified determines which claims must exist for the subject legal person, as identified in the request URL, and any associated legal persons (i.e. directors and people with significant control of a corporation).  These claims can be found in the &#x60;required-claim-types&#x60; field on a [Workflow](http://docs.griffin.com).  ---  Once a verification is created, the system will perform checks on the claim details. The status of check processing is indicated by the &#x60;verification-status&#x60; in the response body. Initially it will be &#x60;pending&#x60;, and will transition through &#x60;in-progress&#x60; to a final status of &#x60;checks-complete&#x60;.  A &#x60;verification-status&#x60; of &#x60;failed&#x60; indicates something went wrong during check processing. You can initiate another verification to retry the check processing.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.VerificationsApi;
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
    String legalPersonId = "legalPersonId_example";
    try {
      VerificationsInitiateVerificationResponse result = client
              .verifications
              .initiateVerification(workflowUrl, legalPersonId)
              .execute();
      System.out.println(result);
      System.out.println(result.getVerificationUrl());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getLegalPersonUrl());
      System.out.println(result.getWorkflowUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getVerificationChecksUrl());
      System.out.println(result.getRiskRating());
      System.out.println(result.getVerificationStatus());
      System.out.println(result.getVerificationRiskAssessmentsUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling VerificationsApi#initiateVerification");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<VerificationsInitiateVerificationResponse> response = client
              .verifications
              .initiateVerification(workflowUrl, legalPersonId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling VerificationsApi#initiateVerification");
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
| **legalPersonId** | **String**|  | |
| **verificationsInitiateVerificationRequest** | [**VerificationsInitiateVerificationRequest**](VerificationsInitiateVerificationRequest.md)|  | |

### Return type

[**VerificationsInitiateVerificationResponse**](VerificationsInitiateVerificationResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The created verification |  * Location - The URL to check the progress of the test <br>  |
| **400** | Bad Request: specific error details will be provided, if available |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** | Not Found: An associated legal person or workflow does not exist |  -  |
| **409** | Conflict: An existing verification is in-flight |  -  |
| **422** | Unprocessable Entity: specific error details will be provided, if available |  -  |
| **500** | Internal Server Error: please contact support@griffin.com |  -  |
| **502** | Bad Gateway: An error occurred with an external service integration |  -  |

<a name="listForLegalPerson"></a>
# **listForLegalPerson**
> VerificationsListForLegalPersonResponse listForLegalPerson(legalPersonId).sort(sort).pageSize(pageSize).pageAfter(pageAfter).pageBefore(pageBefore).execute();

List verifications for a legal person

List verifications for the given legal person.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.VerificationsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String legalPersonId = "legalPersonId_example";
    String sort = "-created-at"; // 
    Long pageSize = 56L; // 
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    try {
      VerificationsListForLegalPersonResponse result = client
              .verifications
              .listForLegalPerson(legalPersonId)
              .sort(sort)
              .pageSize(pageSize)
              .pageAfter(pageAfter)
              .pageBefore(pageBefore)
              .execute();
      System.out.println(result);
      System.out.println(result.getVerifications());
      System.out.println(result.getLinks());
    } catch (ApiException e) {
      System.err.println("Exception when calling VerificationsApi#listForLegalPerson");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<VerificationsListForLegalPersonResponse> response = client
              .verifications
              .listForLegalPerson(legalPersonId)
              .sort(sort)
              .pageSize(pageSize)
              .pageAfter(pageAfter)
              .pageBefore(pageBefore)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling VerificationsApi#listForLegalPerson");
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
| **legalPersonId** | **String**|  | |
| **sort** | **String**|  | [optional] [enum: -created-at, created-at] |
| **pageSize** | **Long**|  | [optional] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |

### Return type

[**VerificationsListForLegalPersonResponse**](VerificationsListForLegalPersonResponse.md)

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

