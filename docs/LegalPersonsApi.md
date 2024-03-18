# LegalPersonsApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNewLegalPerson**](LegalPersonsApi.md#createNewLegalPerson) | **POST** /v0/organizations/{organization-id}/legal-persons | Create legal person |
| [**getLegalPerson**](LegalPersonsApi.md#getLegalPerson) | **GET** /v0/legal-persons/{legal-person-id} | Get legal person |
| [**listLegalPersons**](LegalPersonsApi.md#listLegalPersons) | **GET** /v0/organizations/{organization-id}/legal-persons | List legal persons |
| [**updateLegalPerson**](LegalPersonsApi.md#updateLegalPerson) | **PUT** /v0/legal-persons/{legal-person-id} | Update legal person |


<a name="createNewLegalPerson"></a>
# **createNewLegalPerson**
> LegalPersonsCreateNewLegalPersonResponse createNewLegalPerson(organizationId, legalPersonsCreateNewLegalPersonRequest).execute();

Create legal person

Creates a new Legal Person. A collection of [Claims](http://docs.griffin.com) may be provided.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LegalPersonsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String displayName = "displayName_example"; // A human readable label for an entity
    String legalPersonType = "individual"; // Specifies if the legal person is an `individual` or a `corporation`.
    String organizationId = "organizationId_example";
    List<MobileNumber> claims = Arrays.asList();
    try {
      LegalPersonsCreateNewLegalPersonResponse result = client
              .legalPersons
              .createNewLegalPerson(displayName, legalPersonType, organizationId)
              .claims(claims)
              .execute();
      System.out.println(result);
      System.out.println(result.getLatestDecision());
      System.out.println(result.getLegalPersonType());
      System.out.println(result.getLatestRiskRatingUrl());
      System.out.println(result.getDisplayName());
      System.out.println(result.getApplicationStatus());
      System.out.println(result.getLegalPersonUrl());
      System.out.println(result.getLegalPersonDecisionsUrl());
      System.out.println(result.getStatusChangedAt());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getLegalPersonClaimsUrl());
      System.out.println(result.getLegalPersonBankPayeesUrl());
      System.out.println(result.getLegalPersonVerificationsUrl());
      System.out.println(result.getLegalPersonDocumentsUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalPersonsApi#createNewLegalPerson");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<LegalPersonsCreateNewLegalPersonResponse> response = client
              .legalPersons
              .createNewLegalPerson(displayName, legalPersonType, organizationId)
              .claims(claims)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalPersonsApi#createNewLegalPerson");
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
| **legalPersonsCreateNewLegalPersonRequest** | [**LegalPersonsCreateNewLegalPersonRequest**](LegalPersonsCreateNewLegalPersonRequest.md)|  | |

### Return type

[**LegalPersonsCreateNewLegalPersonResponse**](LegalPersonsCreateNewLegalPersonResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  * Location - The URL to check the progress of the test <br>  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |
| **422** |  |  -  |

<a name="getLegalPerson"></a>
# **getLegalPerson**
> LegalPersonsGetLegalPersonResponse getLegalPerson(legalPersonId).execute();

Get legal person

Yields the legal-person.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LegalPersonsApi;
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
    try {
      LegalPersonsGetLegalPersonResponse result = client
              .legalPersons
              .getLegalPerson(legalPersonId)
              .execute();
      System.out.println(result);
      System.out.println(result.getLatestDecision());
      System.out.println(result.getLegalPersonType());
      System.out.println(result.getLatestRiskRatingUrl());
      System.out.println(result.getDisplayName());
      System.out.println(result.getApplicationStatus());
      System.out.println(result.getLegalPersonUrl());
      System.out.println(result.getLegalPersonDecisionsUrl());
      System.out.println(result.getStatusChangedAt());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getLegalPersonClaimsUrl());
      System.out.println(result.getLegalPersonBankPayeesUrl());
      System.out.println(result.getLegalPersonVerificationsUrl());
      System.out.println(result.getLegalPersonDocumentsUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalPersonsApi#getLegalPerson");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<LegalPersonsGetLegalPersonResponse> response = client
              .legalPersons
              .getLegalPerson(legalPersonId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalPersonsApi#getLegalPerson");
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

### Return type

[**LegalPersonsGetLegalPersonResponse**](LegalPersonsGetLegalPersonResponse.md)

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

<a name="listLegalPersons"></a>
# **listLegalPersons**
> LegalPersonsListLegalPersonsResponse listLegalPersons(organizationId).sort(sort).include(include).filterApplicationStatusEq(filterApplicationStatusEq).filterHas(filterHas).pageSize(pageSize).pageAfter(pageAfter).pageBefore(pageBefore).execute();

List legal persons

Returns a paginated list of all legal persons for the given organization.  By default, results are sorted descending by &#x60;created-at&#x60; (newest first). To sort ascending by &#x60;created-at&#x60;, provide a &#x60;?sort&#x3D;created-at&#x60; query parameter. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LegalPersonsApi;
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
    String sort = "-status-changed-at"; // 
    List<String> include = Arrays.asList(); // For each legal person returned, include its latest verification (if one exists), and/or its latest risk rating (if one exists) in the response under the `included` attribute.
    String filterApplicationStatusEq = "referred"; // Return only legal persons with the given application-status.
    List<String> filterHas = Arrays.asList(); // Return only legal persons with the given attributes.
    Long pageSize = 56L; // 
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    try {
      LegalPersonsListLegalPersonsResponse result = client
              .legalPersons
              .listLegalPersons(organizationId)
              .sort(sort)
              .include(include)
              .filterApplicationStatusEq(filterApplicationStatusEq)
              .filterHas(filterHas)
              .pageSize(pageSize)
              .pageAfter(pageAfter)
              .pageBefore(pageBefore)
              .execute();
      System.out.println(result);
      System.out.println(result.getLegalPersons());
      System.out.println(result.getLinks());
      System.out.println(result.getMeta());
      System.out.println(result.getIncluded());
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalPersonsApi#listLegalPersons");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<LegalPersonsListLegalPersonsResponse> response = client
              .legalPersons
              .listLegalPersons(organizationId)
              .sort(sort)
              .include(include)
              .filterApplicationStatusEq(filterApplicationStatusEq)
              .filterHas(filterHas)
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
      System.err.println("Exception when calling LegalPersonsApi#listLegalPersons");
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
| **sort** | **String**|  | [optional] [enum: -status-changed-at, status-changed-at, -created-at, created-at] |
| **include** | [**List&lt;String&gt;**](String.md)| For each legal person returned, include its latest verification (if one exists), and/or its latest risk rating (if one exists) in the response under the &#x60;included&#x60; attribute. | [optional] [enum: latest-risk-rating, latest-verification] |
| **filterApplicationStatusEq** | **String**| Return only legal persons with the given application-status. | [optional] [enum: referred, errored, declined, submitted, accepted] |
| **filterHas** | [**List&lt;String&gt;**](String.md)| Return only legal persons with the given attributes. | [optional] [enum: application-status] |
| **pageSize** | **Long**|  | [optional] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |

### Return type

[**LegalPersonsListLegalPersonsResponse**](LegalPersonsListLegalPersonsResponse.md)

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

<a name="updateLegalPerson"></a>
# **updateLegalPerson**
> LegalPersonsUpdateLegalPersonResponse updateLegalPerson(legalPersonId, legalPersonsUpdateLegalPersonRequest).execute();

Update legal person

Updates the legal-person.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LegalPersonsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String displayName = "displayName_example"; // A human readable label for an entity
    String legalPersonId = "legalPersonId_example";
    try {
      LegalPersonsUpdateLegalPersonResponse result = client
              .legalPersons
              .updateLegalPerson(displayName, legalPersonId)
              .execute();
      System.out.println(result);
      System.out.println(result.getLatestDecision());
      System.out.println(result.getLegalPersonType());
      System.out.println(result.getLatestRiskRatingUrl());
      System.out.println(result.getDisplayName());
      System.out.println(result.getApplicationStatus());
      System.out.println(result.getLegalPersonUrl());
      System.out.println(result.getLegalPersonDecisionsUrl());
      System.out.println(result.getStatusChangedAt());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getLegalPersonClaimsUrl());
      System.out.println(result.getLegalPersonBankPayeesUrl());
      System.out.println(result.getLegalPersonVerificationsUrl());
      System.out.println(result.getLegalPersonDocumentsUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalPersonsApi#updateLegalPerson");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<LegalPersonsUpdateLegalPersonResponse> response = client
              .legalPersons
              .updateLegalPerson(displayName, legalPersonId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalPersonsApi#updateLegalPerson");
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
| **legalPersonsUpdateLegalPersonRequest** | [**LegalPersonsUpdateLegalPersonRequest**](LegalPersonsUpdateLegalPersonRequest.md)|  | |

### Return type

[**LegalPersonsUpdateLegalPersonResponse**](LegalPersonsUpdateLegalPersonResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Location - The URL to check the progress of the test <br>  |
| **400** | Responds with bad-request if the body does not conform to the schema. |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |
| **422** |  |  -  |

