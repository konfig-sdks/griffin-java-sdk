# CompaniesHouseApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getCompanyDetails**](CompaniesHouseApi.md#getCompanyDetails) | **GET** /v0/companies-house/companies/{company-number} | Lookup company |


<a name="getCompanyDetails"></a>
# **getCompanyDetails**
> CompaniesHouseGetCompanyDetailsResponse getCompanyDetails(companyNumber).execute();

Lookup company

Lookup Companies House company by company number. Includes information about the company, its directors, and persons with significant control.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CompaniesHouseApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String companyNumber = "10842931"; // UK Companies House company number
    try {
      CompaniesHouseGetCompanyDetailsResponse result = client
              .companiesHouse
              .getCompanyDetails(companyNumber)
              .execute();
      System.out.println(result);
      System.out.println(result.getCompanyAddress());
      System.out.println(result.getDateOfLatestAccounts());
      System.out.println(result.getEntityName());
      System.out.println(result.getDirectors());
      System.out.println(result.getDateOfLatestConfirmationStatement());
      System.out.println(result.getCorporationType());
      System.out.println(result.getCompanyStatus());
      System.out.println(result.getAccountsOverdue());
      System.out.println(result.getSicCodes());
      System.out.println(result.getPersonsWithSignificantControl());
      System.out.println(result.getConfirmationStatementOverdue());
      System.out.println(result.getDateOfIncorporation());
      System.out.println(result.getEntityRegistrationNumber());
    } catch (ApiException e) {
      System.err.println("Exception when calling CompaniesHouseApi#getCompanyDetails");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CompaniesHouseGetCompanyDetailsResponse> response = client
              .companiesHouse
              .getCompanyDetails(companyNumber)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CompaniesHouseApi#getCompanyDetails");
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
| **companyNumber** | **String**| UK Companies House company number | |

### Return type

[**CompaniesHouseGetCompanyDetailsResponse**](CompaniesHouseGetCompanyDetailsResponse.md)

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
| **500** |  |  -  |
| **502** |  |  -  |

