# ClaimsApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNewClaim**](ClaimsApi.md#createNewClaim) | **POST** /v0/legal-persons/{legal-person-id}/claims | Create claim |
| [**getAllClaims**](ClaimsApi.md#getAllClaims) | **GET** /v0/legal-persons/{legal-person-id}/claims | List claims |


<a name="createNewClaim"></a>
# **createNewClaim**
> ClaimsCreateNewClaimResponse createNewClaim(legalPersonId, claimsCreateNewClaimRequest).execute();

Create claim

Creates a new claim about a Legal Person.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ClaimsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String claimType = "mobile-number";
    String legalPersonId = "legalPersonId_example";
    Object mobileNumber = null;
    LocalDate dateOfBirth = LocalDate.now(); // ISO 8601 formatted date.
    String givenName = "givenName_example";
    String surname = "surname_example";
    String middleName = "middleName_example";
    String tradingName = "tradingName_example";
    BothBuildingNameAndBuildingNumberProperty tradingAddress = new BothBuildingNameAndBuildingNumberProperty();
    Object emailAddress = null;
    String city = "city_example";
    String buildingName = "buildingName_example";
    String streetName = "streetName_example";
    String entityName = "entityName_example";
    String postalCode = "postalCode_example";
    String corporationType = "private-limited-guarant-nsc-limited-exemption";
    Object telephoneNumber = null;
    String buildingNumber = "buildingNumber_example";
    Object countryCode = null;
    LocalDate dateOfIncorporation = LocalDate.now(); // ISO 8601 formatted date.
    String entityRegistrationNumber = "entityRegistrationNumber_example"; // The entity number assigned by the local register. For UK companies that's the Companies House company number.
    IncomeProperty income = new IncomeProperty();
    InitialDepositProperty initialDeposit = new InitialDepositProperty();
    List<Object> internationalPaymentsCountries = Arrays.asList(null);
    String legalPersonUrl = "legalPersonUrl_example"; // A contextual link to the [legal person](http://docs.griffin.com).
    String ownershipPercent = "ownershipPercent_example"; // The percentage ownership the legal person has of the corporation.
    String companiesHouseUrl = "companiesHouseUrl_example"; // The URL of the entity in Companies House
    Boolean seniorManagerQuestionMark = true;
    Object taxResidency = null; // ISO 3166-1 alpha-2 two-letter country code.
    List<String> ukRegulatoryPermissions = Arrays.asList();
    String businessDescription = "businessDescription_example";
    Set<String> individualSourcesOfFunds = Arrays.asList();
    BothBuildingNameAndBuildingNumberProperty businessAddress = new BothBuildingNameAndBuildingNumberProperty();
    AnnualTurnoverProperty annualTurnover = new AnnualTurnoverProperty();
    Set<String> purposesOfAccount = Arrays.asList();
    List<String> sicCodes = Arrays.asList();
    List<Object> internationalOperationsCountries = Arrays.asList(null);
    Set<String> sourcesOfFunds = Arrays.asList();
    Set<String> relianceVerificationMethods = Arrays.asList();
    String relianceVerificationStandard = "jmlsg";
    String businessName = "businessName_example";
    Set<String> individualPurposesOfAccount = Arrays.asList();
    Object nationality = null; // ISO 3166-1 alpha-2 two-letter country code.
    String socialMedia = "socialMedia_example";
    String websiteUrl = "websiteUrl_example";
    String taxIdentificationNumber = "taxIdentificationNumber_example";
    try {
      ClaimsCreateNewClaimResponse result = client
              .claims
              .createNewClaim(claimType, legalPersonId)
              .mobileNumber(mobileNumber)
              .dateOfBirth(dateOfBirth)
              .givenName(givenName)
              .surname(surname)
              .middleName(middleName)
              .tradingName(tradingName)
              .tradingAddress(tradingAddress)
              .emailAddress(emailAddress)
              .city(city)
              .buildingName(buildingName)
              .streetName(streetName)
              .entityName(entityName)
              .postalCode(postalCode)
              .corporationType(corporationType)
              .telephoneNumber(telephoneNumber)
              .buildingNumber(buildingNumber)
              .countryCode(countryCode)
              .dateOfIncorporation(dateOfIncorporation)
              .entityRegistrationNumber(entityRegistrationNumber)
              .income(income)
              .initialDeposit(initialDeposit)
              .internationalPaymentsCountries(internationalPaymentsCountries)
              .legalPersonUrl(legalPersonUrl)
              .ownershipPercent(ownershipPercent)
              .companiesHouseUrl(companiesHouseUrl)
              .seniorManagerQuestionMark(seniorManagerQuestionMark)
              .taxResidency(taxResidency)
              .ukRegulatoryPermissions(ukRegulatoryPermissions)
              .businessDescription(businessDescription)
              .individualSourcesOfFunds(individualSourcesOfFunds)
              .businessAddress(businessAddress)
              .annualTurnover(annualTurnover)
              .purposesOfAccount(purposesOfAccount)
              .sicCodes(sicCodes)
              .internationalOperationsCountries(internationalOperationsCountries)
              .sourcesOfFunds(sourcesOfFunds)
              .relianceVerificationMethods(relianceVerificationMethods)
              .relianceVerificationStandard(relianceVerificationStandard)
              .businessName(businessName)
              .individualPurposesOfAccount(individualPurposesOfAccount)
              .nationality(nationality)
              .socialMedia(socialMedia)
              .websiteUrl(websiteUrl)
              .taxIdentificationNumber(taxIdentificationNumber)
              .execute();
      System.out.println(result);
      System.out.println(result.getMobileNumber());
      System.out.println(result.getClaimType());
      System.out.println(result.getDateOfBirth());
      System.out.println(result.getGivenName());
      System.out.println(result.getSurname());
      System.out.println(result.getMiddleName());
      System.out.println(result.getTradingName());
      System.out.println(result.getTradingAddress());
      System.out.println(result.getEmailAddress());
      System.out.println(result.getCity());
      System.out.println(result.getBuildingName());
      System.out.println(result.getStreetName());
      System.out.println(result.getEntityName());
      System.out.println(result.getPostalCode());
      System.out.println(result.getCorporationType());
      System.out.println(result.getTelephoneNumber());
      System.out.println(result.getBuildingNumber());
      System.out.println(result.getCountryCode());
      System.out.println(result.getDateOfIncorporation());
      System.out.println(result.getEntityRegistrationNumber());
      System.out.println(result.getIncome());
      System.out.println(result.getInitialDeposit());
      System.out.println(result.getInternationalPaymentsCountries());
      System.out.println(result.getLegalPersonUrl());
      System.out.println(result.getOwnershipPercent());
      System.out.println(result.getCompaniesHouseUrl());
      System.out.println(result.getSeniorManagerQuestionMark());
      System.out.println(result.getTaxResidency());
      System.out.println(result.getUkRegulatoryPermissions());
      System.out.println(result.getBusinessDescription());
      System.out.println(result.getIndividualSourcesOfFunds());
      System.out.println(result.getBusinessAddress());
      System.out.println(result.getAnnualTurnover());
      System.out.println(result.getPurposesOfAccount());
      System.out.println(result.getSicCodes());
      System.out.println(result.getInternationalOperationsCountries());
      System.out.println(result.getSourcesOfFunds());
      System.out.println(result.getRelianceVerificationMethods());
      System.out.println(result.getRelianceVerificationStandard());
      System.out.println(result.getBusinessName());
      System.out.println(result.getIndividualPurposesOfAccount());
      System.out.println(result.getNationality());
      System.out.println(result.getSocialMedia());
      System.out.println(result.getWebsiteUrl());
      System.out.println(result.getTaxIdentificationNumber());
    } catch (ApiException e) {
      System.err.println("Exception when calling ClaimsApi#createNewClaim");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ClaimsCreateNewClaimResponse> response = client
              .claims
              .createNewClaim(claimType, legalPersonId)
              .mobileNumber(mobileNumber)
              .dateOfBirth(dateOfBirth)
              .givenName(givenName)
              .surname(surname)
              .middleName(middleName)
              .tradingName(tradingName)
              .tradingAddress(tradingAddress)
              .emailAddress(emailAddress)
              .city(city)
              .buildingName(buildingName)
              .streetName(streetName)
              .entityName(entityName)
              .postalCode(postalCode)
              .corporationType(corporationType)
              .telephoneNumber(telephoneNumber)
              .buildingNumber(buildingNumber)
              .countryCode(countryCode)
              .dateOfIncorporation(dateOfIncorporation)
              .entityRegistrationNumber(entityRegistrationNumber)
              .income(income)
              .initialDeposit(initialDeposit)
              .internationalPaymentsCountries(internationalPaymentsCountries)
              .legalPersonUrl(legalPersonUrl)
              .ownershipPercent(ownershipPercent)
              .companiesHouseUrl(companiesHouseUrl)
              .seniorManagerQuestionMark(seniorManagerQuestionMark)
              .taxResidency(taxResidency)
              .ukRegulatoryPermissions(ukRegulatoryPermissions)
              .businessDescription(businessDescription)
              .individualSourcesOfFunds(individualSourcesOfFunds)
              .businessAddress(businessAddress)
              .annualTurnover(annualTurnover)
              .purposesOfAccount(purposesOfAccount)
              .sicCodes(sicCodes)
              .internationalOperationsCountries(internationalOperationsCountries)
              .sourcesOfFunds(sourcesOfFunds)
              .relianceVerificationMethods(relianceVerificationMethods)
              .relianceVerificationStandard(relianceVerificationStandard)
              .businessName(businessName)
              .individualPurposesOfAccount(individualPurposesOfAccount)
              .nationality(nationality)
              .socialMedia(socialMedia)
              .websiteUrl(websiteUrl)
              .taxIdentificationNumber(taxIdentificationNumber)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ClaimsApi#createNewClaim");
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
| **claimsCreateNewClaimRequest** | [**ClaimsCreateNewClaimRequest**](ClaimsCreateNewClaimRequest.md)|  | |

### Return type

[**ClaimsCreateNewClaimResponse**](ClaimsCreateNewClaimResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |
| **400** | Responds with bad-request if the body does not conform to the schema. |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **422** |  |  -  |

<a name="getAllClaims"></a>
# **getAllClaims**
> ClaimsGetAllClaimsResponse getAllClaims(legalPersonId).sort(sort).pageSize(pageSize).pageAfter(pageAfter).pageBefore(pageBefore).execute();

List claims

Yields a list of all current claims about this Legal Person.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ClaimsApi;
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
      ClaimsGetAllClaimsResponse result = client
              .claims
              .getAllClaims(legalPersonId)
              .sort(sort)
              .pageSize(pageSize)
              .pageAfter(pageAfter)
              .pageBefore(pageBefore)
              .execute();
      System.out.println(result);
      System.out.println(result.getClaims());
      System.out.println(result.getLinks());
    } catch (ApiException e) {
      System.err.println("Exception when calling ClaimsApi#getAllClaims");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ClaimsGetAllClaimsResponse> response = client
              .claims
              .getAllClaims(legalPersonId)
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
      System.err.println("Exception when calling ClaimsApi#getAllClaims");
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

[**ClaimsGetAllClaimsResponse**](ClaimsGetAllClaimsResponse.md)

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

