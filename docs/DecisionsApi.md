# DecisionsApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDecision**](DecisionsApi.md#createDecision) | **POST** /v0/legal-persons/{legal-person-id}/decisions | Create decision |
| [**listForLegalPerson**](DecisionsApi.md#listForLegalPerson) | **GET** /v0/legal-persons/{legal-person-id}/decisions | List decisions |


<a name="createDecision"></a>
# **createDecision**
> DecisionsCreateDecisionResponse createDecision(legalPersonId, decisionsCreateDecisionRequest).execute();

Create decision

Creates a decision against the legal person.  The provided verification must have a &#x60;verification-status&#x60; of &#x60;checks-complete&#x60;, otherwise a 422 is served.  When a decision is successfully created, the legal person&#39;s &#x60;application-status&#x60; is updated accordingly.  Multiple decisions may be made against the same legal person.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.DecisionsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String verificationUrl = "verificationUrl_example"; // A link to the [verification](http://docs.griffin.com).
    String decisionOutcome = "accepted";
    String decisionNotes = "decisionNotes_example"; // Free-text field to explain the reasons behind the decision.
    String legalPersonId = "legalPersonId_example";
    try {
      DecisionsCreateDecisionResponse result = client
              .decisions
              .createDecision(verificationUrl, decisionOutcome, decisionNotes, legalPersonId)
              .execute();
      System.out.println(result);
      System.out.println(result.getVerificationUrl());
      System.out.println(result.getDecisionOutcome());
      System.out.println(result.getDecisionMaker());
      System.out.println(result.getDecisionNotes());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getDecisionUserUrl());
      System.out.println(result.getDecisionUserUsername());
      System.out.println(result.getDecisionOpsUser());
    } catch (ApiException e) {
      System.err.println("Exception when calling DecisionsApi#createDecision");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<DecisionsCreateDecisionResponse> response = client
              .decisions
              .createDecision(verificationUrl, decisionOutcome, decisionNotes, legalPersonId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling DecisionsApi#createDecision");
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
| **decisionsCreateDecisionRequest** | [**DecisionsCreateDecisionRequest**](DecisionsCreateDecisionRequest.md)|  | |

### Return type

[**DecisionsCreateDecisionResponse**](DecisionsCreateDecisionResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **403** |  |  -  |
| **404** |  |  -  |
| **422** |  |  -  |
| **500** |  |  -  |
| **503** |  |  -  |

<a name="listForLegalPerson"></a>
# **listForLegalPerson**
> DecisionsListForLegalPersonResponse listForLegalPerson(legalPersonId).sort(sort).pageSize(pageSize).pageAfter(pageAfter).pageBefore(pageBefore).execute();

List decisions

Lists all decisions for the given legal-person.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.DecisionsApi;
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
      DecisionsListForLegalPersonResponse result = client
              .decisions
              .listForLegalPerson(legalPersonId)
              .sort(sort)
              .pageSize(pageSize)
              .pageAfter(pageAfter)
              .pageBefore(pageBefore)
              .execute();
      System.out.println(result);
      System.out.println(result.getDecisions());
      System.out.println(result.getLinks());
    } catch (ApiException e) {
      System.err.println("Exception when calling DecisionsApi#listForLegalPerson");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<DecisionsListForLegalPersonResponse> response = client
              .decisions
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
      System.err.println("Exception when calling DecisionsApi#listForLegalPerson");
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

[**DecisionsListForLegalPersonResponse**](DecisionsListForLegalPersonResponse.md)

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

