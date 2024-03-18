# PaymentsApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createRequest**](PaymentsApi.md#createRequest) | **POST** /v0/bank/accounts/{bank-account-id}/payments | Create payment |
| [**getAdmission**](PaymentsApi.md#getAdmission) | **GET** /v0/admissions/{admission-id} | Get payment admission |
| [**getBankAccountPayments**](PaymentsApi.md#getBankAccountPayments) | **GET** /v0/bank/accounts/{bank-account-id}/payments | List bank account payments |
| [**getDetails**](PaymentsApi.md#getDetails) | **GET** /v0/payments/{payment-id} | Get payment |
| [**getSubmission**](PaymentsApi.md#getSubmission) | **GET** /v0/submissions/{submission-id} | Get payment submission |
| [**listAdmissions**](PaymentsApi.md#listAdmissions) | **GET** /v0/payments/{payment-id}/admissions | List payment admissions |
| [**listBankAccountAdmissions**](PaymentsApi.md#listBankAccountAdmissions) | **GET** /v0/bank/accounts/{bank-account-id}/admissions | List bank account admissions |
| [**listSubmissions**](PaymentsApi.md#listSubmissions) | **GET** /v0/bank/accounts/{bank-account-id}/submissions | List bank account submissions |
| [**listSubmissions_0**](PaymentsApi.md#listSubmissions_0) | **GET** /v0/payments/{payment-id}/submissions | List payment submissions |
| [**submitPaymentSubmission**](PaymentsApi.md#submitPaymentSubmission) | **POST** /v0/payments/{payment-id}/submissions | Submit payment |


<a name="createRequest"></a>
# **createRequest**
> PaymentsCreateRequestResponse createRequest(bankAccountId, paymentsCreateRequestRequest).execute();

Create payment

Registers a new payment request for the bank account

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    PayeeProperty creditor = new PayeeProperty();
    PaymentAmountProperty paymentAmount = new PaymentAmountProperty();
    String bankAccountId = "bankAccountId_example";
    String paymentReference = "paymentReference_example"; // Free-text field to help identify and categorise payments.
    try {
      PaymentsCreateRequestResponse result = client
              .payments
              .createRequest(creditor, paymentAmount, bankAccountId)
              .paymentReference(paymentReference)
              .execute();
      System.out.println(result);
      System.out.println(result.getCreditor());
      System.out.println(result.getPaymentDirection());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getPaymentUrl());
      System.out.println(result.getPaymentReference());
      System.out.println(result.getPaymentAmount());
      System.out.println(result.getUltimateDebtor());
      System.out.println(result.getPaymentAdmissionsUrl());
      System.out.println(result.getPaymentSubmissionsUrl());
      System.out.println(result.getDebtor());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#createRequest");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentsCreateRequestResponse> response = client
              .payments
              .createRequest(creditor, paymentAmount, bankAccountId)
              .paymentReference(paymentReference)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#createRequest");
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
| **bankAccountId** | **String**|  | |
| **paymentsCreateRequestRequest** | [**PaymentsCreateRequestRequest**](PaymentsCreateRequestRequest.md)|  | |

### Return type

[**PaymentsCreateRequestResponse**](PaymentsCreateRequestResponse.md)

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
| **404** |  |  -  |
| **422** | An error occurred when trying to create the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. |  -  |
| **500** |  |  -  |

<a name="getAdmission"></a>
# **getAdmission**
> PaymentsGetAdmissionResponse getAdmission(admissionId).execute();

Get payment admission

Yields an admission.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String admissionId = "admissionId_example";
    try {
      PaymentsGetAdmissionResponse result = client
              .payments
              .getAdmission(admissionId)
              .execute();
      System.out.println(result);
      System.out.println(result.getAdmissionStatus());
      System.out.println(result.getAdmissionSchemeInformation());
      System.out.println(result.getPaymentUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getAdmissionUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#getAdmission");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentsGetAdmissionResponse> response = client
              .payments
              .getAdmission(admissionId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#getAdmission");
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
| **admissionId** | **String**|  | |

### Return type

[**PaymentsGetAdmissionResponse**](PaymentsGetAdmissionResponse.md)

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
| **403** |  |  -  |
| **404** |  |  -  |

<a name="getBankAccountPayments"></a>
# **getBankAccountPayments**
> PaymentsGetBankAccountPaymentsResponse getBankAccountPayments(bankAccountId).sort(sort).pageSize(pageSize).pageBefore(pageBefore).pageAfter(pageAfter).filterCreatedAtLte(filterCreatedAtLte).filterCreatedAtLt(filterCreatedAtLt).filterCreatedAtGte(filterCreatedAtGte).filterCreatedAtGt(filterCreatedAtGt).execute();

List bank account payments

Lists payments made from a bank account.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String bankAccountId = "bankAccountId_example";
    String sort = "-created-at"; // 
    Long pageSize = 56L; // 
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    OffsetDateTime filterCreatedAtLte = OffsetDateTime.now(); // Return only resources with a created-at less than or equal to the given timestamp.
    OffsetDateTime filterCreatedAtLt = OffsetDateTime.now(); // Return only resources with a created-at less than the given timestamp.
    OffsetDateTime filterCreatedAtGte = OffsetDateTime.now(); // Return only resources with a created-at greater than or equal to the given timestamp.
    OffsetDateTime filterCreatedAtGt = OffsetDateTime.now(); // Return only resources with a created-at greater than the given timestamp.
    try {
      PaymentsGetBankAccountPaymentsResponse result = client
              .payments
              .getBankAccountPayments(bankAccountId)
              .sort(sort)
              .pageSize(pageSize)
              .pageBefore(pageBefore)
              .pageAfter(pageAfter)
              .filterCreatedAtLte(filterCreatedAtLte)
              .filterCreatedAtLt(filterCreatedAtLt)
              .filterCreatedAtGte(filterCreatedAtGte)
              .filterCreatedAtGt(filterCreatedAtGt)
              .execute();
      System.out.println(result);
      System.out.println(result.getPayments());
      System.out.println(result.getLinks());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#getBankAccountPayments");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentsGetBankAccountPaymentsResponse> response = client
              .payments
              .getBankAccountPayments(bankAccountId)
              .sort(sort)
              .pageSize(pageSize)
              .pageBefore(pageBefore)
              .pageAfter(pageAfter)
              .filterCreatedAtLte(filterCreatedAtLte)
              .filterCreatedAtLt(filterCreatedAtLt)
              .filterCreatedAtGte(filterCreatedAtGte)
              .filterCreatedAtGt(filterCreatedAtGt)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#getBankAccountPayments");
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
| **bankAccountId** | **String**|  | |
| **sort** | **String**|  | [optional] [enum: -created-at, created-at] |
| **pageSize** | **Long**|  | [optional] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **filterCreatedAtLte** | **OffsetDateTime**| Return only resources with a created-at less than or equal to the given timestamp. | [optional] |
| **filterCreatedAtLt** | **OffsetDateTime**| Return only resources with a created-at less than the given timestamp. | [optional] |
| **filterCreatedAtGte** | **OffsetDateTime**| Return only resources with a created-at greater than or equal to the given timestamp. | [optional] |
| **filterCreatedAtGt** | **OffsetDateTime**| Return only resources with a created-at greater than the given timestamp. | [optional] |

### Return type

[**PaymentsGetBankAccountPaymentsResponse**](PaymentsGetBankAccountPaymentsResponse.md)

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

<a name="getDetails"></a>
# **getDetails**
> PaymentsGetDetailsResponse getDetails(paymentId).execute();

Get payment

Yields payment details

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String paymentId = "paymentId_example";
    try {
      PaymentsGetDetailsResponse result = client
              .payments
              .getDetails(paymentId)
              .execute();
      System.out.println(result);
      System.out.println(result.getCreditor());
      System.out.println(result.getPaymentDirection());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getPaymentUrl());
      System.out.println(result.getPaymentReference());
      System.out.println(result.getPaymentAmount());
      System.out.println(result.getUltimateDebtor());
      System.out.println(result.getPaymentAdmissionsUrl());
      System.out.println(result.getPaymentSubmissionsUrl());
      System.out.println(result.getDebtor());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#getDetails");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentsGetDetailsResponse> response = client
              .payments
              .getDetails(paymentId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#getDetails");
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
| **paymentId** | **String**|  | |

### Return type

[**PaymentsGetDetailsResponse**](PaymentsGetDetailsResponse.md)

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

<a name="getSubmission"></a>
# **getSubmission**
> PaymentsGetSubmissionResponse getSubmission(submissionId).execute();

Get payment submission

Yields a submission.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String submissionId = "submissionId_example";
    try {
      PaymentsGetSubmissionResponse result = client
              .payments
              .getSubmission(submissionId)
              .execute();
      System.out.println(result);
      System.out.println(result.getSubmissionStatus());
      System.out.println(result.getSubmissionSchemeInformation());
      System.out.println(result.getPaymentUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getSubmissionUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#getSubmission");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentsGetSubmissionResponse> response = client
              .payments
              .getSubmission(submissionId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#getSubmission");
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
| **submissionId** | **String**|  | |

### Return type

[**PaymentsGetSubmissionResponse**](PaymentsGetSubmissionResponse.md)

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
| **403** |  |  -  |
| **404** |  |  -  |

<a name="listAdmissions"></a>
# **listAdmissions**
> PaymentsListAdmissionsResponse listAdmissions(paymentId).execute();

List payment admissions

Lists admissions for a payment. A payment may have at most one admission.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String paymentId = "paymentId_example";
    try {
      PaymentsListAdmissionsResponse result = client
              .payments
              .listAdmissions(paymentId)
              .execute();
      System.out.println(result);
      System.out.println(result.getAdmissions());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#listAdmissions");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentsListAdmissionsResponse> response = client
              .payments
              .listAdmissions(paymentId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#listAdmissions");
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
| **paymentId** | **String**|  | |

### Return type

[**PaymentsListAdmissionsResponse**](PaymentsListAdmissionsResponse.md)

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

<a name="listBankAccountAdmissions"></a>
# **listBankAccountAdmissions**
> PaymentsListBankAccountAdmissionsResponse listBankAccountAdmissions(bankAccountId).sort(sort).pageSize(pageSize).pageBefore(pageBefore).pageAfter(pageAfter).filterCreatedAtLte(filterCreatedAtLte).filterCreatedAtLt(filterCreatedAtLt).filterCreatedAtGte(filterCreatedAtGte).filterCreatedAtGt(filterCreatedAtGt).filterAdmissionStatusIn(filterAdmissionStatusIn).execute();

List bank account admissions

Lists admissions targeting a bank account

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String bankAccountId = "bankAccountId_example";
    String sort = "-created-at"; // 
    Long pageSize = 56L; // 
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    OffsetDateTime filterCreatedAtLte = OffsetDateTime.now(); // Return only resources with a created-at less than or equal to the given timestamp.
    OffsetDateTime filterCreatedAtLt = OffsetDateTime.now(); // Return only resources with a created-at less than the given timestamp.
    OffsetDateTime filterCreatedAtGte = OffsetDateTime.now(); // Return only resources with a created-at greater than or equal to the given timestamp.
    OffsetDateTime filterCreatedAtGt = OffsetDateTime.now(); // Return only resources with a created-at greater than the given timestamp.
    List<String> filterAdmissionStatusIn = Arrays.asList(); // 
    try {
      PaymentsListBankAccountAdmissionsResponse result = client
              .payments
              .listBankAccountAdmissions(bankAccountId)
              .sort(sort)
              .pageSize(pageSize)
              .pageBefore(pageBefore)
              .pageAfter(pageAfter)
              .filterCreatedAtLte(filterCreatedAtLte)
              .filterCreatedAtLt(filterCreatedAtLt)
              .filterCreatedAtGte(filterCreatedAtGte)
              .filterCreatedAtGt(filterCreatedAtGt)
              .filterAdmissionStatusIn(filterAdmissionStatusIn)
              .execute();
      System.out.println(result);
      System.out.println(result.getAdmissions());
      System.out.println(result.getLinks());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#listBankAccountAdmissions");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentsListBankAccountAdmissionsResponse> response = client
              .payments
              .listBankAccountAdmissions(bankAccountId)
              .sort(sort)
              .pageSize(pageSize)
              .pageBefore(pageBefore)
              .pageAfter(pageAfter)
              .filterCreatedAtLte(filterCreatedAtLte)
              .filterCreatedAtLt(filterCreatedAtLt)
              .filterCreatedAtGte(filterCreatedAtGte)
              .filterCreatedAtGt(filterCreatedAtGt)
              .filterAdmissionStatusIn(filterAdmissionStatusIn)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#listBankAccountAdmissions");
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
| **bankAccountId** | **String**|  | |
| **sort** | **String**|  | [optional] [enum: -created-at, created-at] |
| **pageSize** | **Long**|  | [optional] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **filterCreatedAtLte** | **OffsetDateTime**| Return only resources with a created-at less than or equal to the given timestamp. | [optional] |
| **filterCreatedAtLt** | **OffsetDateTime**| Return only resources with a created-at less than the given timestamp. | [optional] |
| **filterCreatedAtGte** | **OffsetDateTime**| Return only resources with a created-at greater than or equal to the given timestamp. | [optional] |
| **filterCreatedAtGt** | **OffsetDateTime**| Return only resources with a created-at greater than the given timestamp. | [optional] |
| **filterAdmissionStatusIn** | [**List&lt;String&gt;**](String.md)|  | [optional] [enum: processing, returned, delivered] |

### Return type

[**PaymentsListBankAccountAdmissionsResponse**](PaymentsListBankAccountAdmissionsResponse.md)

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

<a name="listSubmissions"></a>
# **listSubmissions**
> PaymentsListSubmissionsResponse listSubmissions(bankAccountId).sort(sort).pageSize(pageSize).pageBefore(pageBefore).pageAfter(pageAfter).filterSubmissionStatusIn(filterSubmissionStatusIn).filterCreatedAtLte(filterCreatedAtLte).filterCreatedAtLt(filterCreatedAtLt).filterCreatedAtGte(filterCreatedAtGte).filterCreatedAtGt(filterCreatedAtGt).execute();

List bank account submissions

Lists submissions originating from a bank account

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String bankAccountId = "bankAccountId_example";
    String sort = "-created-at"; // 
    Long pageSize = 56L; // 
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    List<String> filterSubmissionStatusIn = Arrays.asList(); // 
    OffsetDateTime filterCreatedAtLte = OffsetDateTime.now(); // Return only resources with a created-at less than or equal to the given timestamp.
    OffsetDateTime filterCreatedAtLt = OffsetDateTime.now(); // Return only resources with a created-at less than the given timestamp.
    OffsetDateTime filterCreatedAtGte = OffsetDateTime.now(); // Return only resources with a created-at greater than or equal to the given timestamp.
    OffsetDateTime filterCreatedAtGt = OffsetDateTime.now(); // Return only resources with a created-at greater than the given timestamp.
    try {
      PaymentsListSubmissionsResponse result = client
              .payments
              .listSubmissions(bankAccountId)
              .sort(sort)
              .pageSize(pageSize)
              .pageBefore(pageBefore)
              .pageAfter(pageAfter)
              .filterSubmissionStatusIn(filterSubmissionStatusIn)
              .filterCreatedAtLte(filterCreatedAtLte)
              .filterCreatedAtLt(filterCreatedAtLt)
              .filterCreatedAtGte(filterCreatedAtGte)
              .filterCreatedAtGt(filterCreatedAtGt)
              .execute();
      System.out.println(result);
      System.out.println(result.getSubmissions());
      System.out.println(result.getLinks());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#listSubmissions");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentsListSubmissionsResponse> response = client
              .payments
              .listSubmissions(bankAccountId)
              .sort(sort)
              .pageSize(pageSize)
              .pageBefore(pageBefore)
              .pageAfter(pageAfter)
              .filterSubmissionStatusIn(filterSubmissionStatusIn)
              .filterCreatedAtLte(filterCreatedAtLte)
              .filterCreatedAtLt(filterCreatedAtLt)
              .filterCreatedAtGte(filterCreatedAtGte)
              .filterCreatedAtGt(filterCreatedAtGt)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#listSubmissions");
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
| **bankAccountId** | **String**|  | |
| **sort** | **String**|  | [optional] [enum: -created-at, created-at] |
| **pageSize** | **Long**|  | [optional] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **filterSubmissionStatusIn** | [**List&lt;String&gt;**](String.md)|  | [optional] [enum: failed, processing, returned, delivered] |
| **filterCreatedAtLte** | **OffsetDateTime**| Return only resources with a created-at less than or equal to the given timestamp. | [optional] |
| **filterCreatedAtLt** | **OffsetDateTime**| Return only resources with a created-at less than the given timestamp. | [optional] |
| **filterCreatedAtGte** | **OffsetDateTime**| Return only resources with a created-at greater than or equal to the given timestamp. | [optional] |
| **filterCreatedAtGt** | **OffsetDateTime**| Return only resources with a created-at greater than the given timestamp. | [optional] |

### Return type

[**PaymentsListSubmissionsResponse**](PaymentsListSubmissionsResponse.md)

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

<a name="listSubmissions_0"></a>
# **listSubmissions_0**
> PaymentsListSubmissions200Response listSubmissions_0(paymentId).execute();

List payment submissions

Lists submissions for a payment. The presence of a submission means that the payment has been submitted.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String paymentId = "paymentId_example";
    try {
      PaymentsListSubmissions200Response result = client
              .payments
              .listSubmissions_0(paymentId)
              .execute();
      System.out.println(result);
      System.out.println(result.getSubmissions());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#listSubmissions_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentsListSubmissions200Response> response = client
              .payments
              .listSubmissions_0(paymentId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#listSubmissions_0");
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
| **paymentId** | **String**|  | |

### Return type

[**PaymentsListSubmissions200Response**](PaymentsListSubmissions200Response.md)

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

<a name="submitPaymentSubmission"></a>
# **submitPaymentSubmission**
> PaymentsSubmitPaymentSubmissionResponse submitPaymentSubmission(paymentId, paymentsSubmitPaymentSubmissionRequest).execute();

Submit payment

Submits a previously created payment for execution.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String paymentId = "paymentId_example";
    String paymentScheme = "fps"; // Specifies the scheme over which a payment is executed.
    try {
      PaymentsSubmitPaymentSubmissionResponse result = client
              .payments
              .submitPaymentSubmission(paymentId)
              .paymentScheme(paymentScheme)
              .execute();
      System.out.println(result);
      System.out.println(result.getSubmissionStatus());
      System.out.println(result.getSubmissionSchemeInformation());
      System.out.println(result.getPaymentUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getSubmissionUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#submitPaymentSubmission");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentsSubmitPaymentSubmissionResponse> response = client
              .payments
              .submitPaymentSubmission(paymentId)
              .paymentScheme(paymentScheme)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#submitPaymentSubmission");
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
| **paymentId** | **String**|  | |
| **paymentsSubmitPaymentSubmissionRequest** | [**PaymentsSubmitPaymentSubmissionRequest**](PaymentsSubmitPaymentSubmissionRequest.md)|  | |

### Return type

[**PaymentsSubmitPaymentSubmissionResponse**](PaymentsSubmitPaymentSubmissionResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |
| **410** |  |  -  |
| **422** | An error occurred when trying to submit the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. |  -  |

