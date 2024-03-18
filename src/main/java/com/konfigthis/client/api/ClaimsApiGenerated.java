/*
 * The Griffin API
 * ## Introduction  The Griffin API is based on [REST](https://en.wikipedia.org/wiki/Representational_state_transfer). It has resource-oriented URLs, accepts [JSON](https://www.json.org/json-en.html)-encoded request bodies, returns [JSON](https://www.json.org/json-en.html)-encoded responses, and uses standard HTTP response verbs and response codes.  Our API deviates from strict RESTful principles if it makes sense to do so, such as when we enforce tighter access controls around certain operations. For example, when closing a bank account: rather than send a PATCH request to the [bank account](http://docs.griffin.com) resource to update it's status to `\"closed\"`, we provide a dedicated account closure resource.  Anyone can [create an account](https://app.griffin.com/register) with Griffin and try out out API in [sandbox mode](http://docs.griffin.com).  New to Griffin? Check out our [getting started guide](http://docs.griffin.com).  ## Navigation  Our API is designed to be navigated programmatically. When you request any resource, you will find the URLs for related resources in the response body.  The API is structured as a tree with your [organization](http://docs.griffin.com) at the top. Everything that you own will be a sub-resource of your organization.  To bootstrap the navigation process, request the [index](http://docs.griffin.com) endpoint: the response will contain your `organization-url`.  For a walkthrough, see our [getting started guide](http://docs.griffin.com).  ## Pagination  Our list APIs support pagination (e.g. [list bank accounts](http://docs.griffin.com) and [list payments](http://docs.griffin.com)). By default, a list API returns up to 25 results. If there are more results available, the response payload will include links to the previous/next pages.  ### Change page size  You can request a different number of results (between 1 and 200, inclusive) by using the `page[size]` query parameter:  ``` GET /v0/organizations/:id/bank/accounts?page[size]=100 ```  ### Navigating between pages  List responses will include a `links` object with `prev` and `next` attributes, as shown below. Perform a GET request to the value of the attribute to fetch the previous/next page of results.  ``` {   \"accounts\": [     // ...   ],   \"links\": {     \"prev\": \"/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/bank/accounts?page[before]=djE6WxSPxfYUTnCU9XtWzj9gGA\",     \"next\": \"/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/bank/accounts?page[after]=djE6aw79PXZySUOL16LD8HRJ3A\"   } }  ``` If there is no previous or next page available, the value of the attribute will be  null.  Any other query parameters included in the initial request will also be included in the response payload's links. If you want to change parameters (see [filtering and sorting](http://docs.griffin.com)), request the first page and follow the links from there.  ## Filtering and sorting  ### Sort results  By default, resources will be listed in descending order, usually based on the `created-at` attribute. You can change the sorting behaviour of a list of results by using the `sort` query parameter.  For example, to list bank accounts in ascending order (oldest first):  ``` GET /v0/organizations/:id/bank/accounts?sort=created-at ```  To _explicitly_ sort in descending order (newest first), prefix the sort attribute with `-`:  ``` GET /v0/organizations/:id/bank/accounts?sort=-created-at ```  ### Filter results  Some list APIs allow you to filter the results. Filters are expressed as nested data structures encoded into query parameters. For example, you can list bank accounts that are in either the `opening` or `open` state with:  ``` GET /v0/organizations/:id/bank/accounts?filter[account-status][in][]=opening&filter[account-status][in][]=open ```  Similarly, you can list legal persons with a specific `application-status`:  ``` GET /v0/organizations/:id/legal-persons?filter[application-status][eq]=accepted ```  ### Include resources  Some list APIs allow you to include associated resources in the response, reducing the number of requests needed to fetch related data. For instance, when listing bank accounts, you can include each bank account's beneficiary legal person by using the `include` query parameter:  ``` GET /v0/organizations/:id/bank/accounts?include=beneficiary ```  The response returns the usual list of bank accounts, but it will also have an `included` object with a `legal-persons` attribute:  ``` {   \"accounts\": [     // ...   ],   \"links\": {     // ...   }   \"included\": {     \"legal-persons\": [       // ...     ]   } } ```  Check the documentation for each list API to see all options for sorting and filtering  ## Versioning  The Griffin API is versioned via a prefix in the URL. The current version is v0. An example endpoint is: https://api.griffin.com/v0/index.  We will not break your integration with a particular version for as long as we support that version. If we release a new version, you will have 12 months to upgrade to it.
 *
 * The version of the OpenAPI document: 
 * 
 *
 * NOTE: This class is auto generated by Konfig (https://konfigthis.com).
 * Do not edit the class manually.
 */


package com.konfigthis.client.api;

import com.konfigthis.client.ApiCallback;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.Pair;
import com.konfigthis.client.ProgressRequestBody;
import com.konfigthis.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.konfigthis.client.model.AnnualTurnoverProperty;
import com.konfigthis.client.model.BothBuildingNameAndBuildingNumberProperty;
import com.konfigthis.client.model.ClaimsCreateNewClaimRequest;
import com.konfigthis.client.model.ClaimsCreateNewClaimResponse;
import com.konfigthis.client.model.ClaimsGetAllClaimsResponse;
import com.konfigthis.client.model.IncomeProperty;
import com.konfigthis.client.model.InitialDepositProperty;
import java.time.LocalDate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class ClaimsApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ClaimsApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public ClaimsApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
        if (apiClient.getApiKeyAuth() == null) {
            throw new IllegalArgumentException("\"Authorization\" is required but no API key was provided. Please set \"Authorization\" with ApiClient#setApiKeyAuth(String).");
        }
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    private okhttp3.Call createNewClaimCall(String legalPersonId, ClaimsCreateNewClaimRequest claimsCreateNewClaimRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = claimsCreateNewClaimRequest;

        // create path and map variables
        String localVarPath = "/v0/legal-persons/{legal-person-id}/claims"
            .replace("{" + "legal-person-id" + "}", localVarApiClient.escapeString(legalPersonId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "api-key-auth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createNewClaimValidateBeforeCall(String legalPersonId, ClaimsCreateNewClaimRequest claimsCreateNewClaimRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'legalPersonId' is set
        if (legalPersonId == null) {
            throw new ApiException("Missing the required parameter 'legalPersonId' when calling createNewClaim(Async)");
        }

        // verify the required parameter 'claimsCreateNewClaimRequest' is set
        if (claimsCreateNewClaimRequest == null) {
            throw new ApiException("Missing the required parameter 'claimsCreateNewClaimRequest' when calling createNewClaim(Async)");
        }

        return createNewClaimCall(legalPersonId, claimsCreateNewClaimRequest, _callback);

    }


    private ApiResponse<ClaimsCreateNewClaimResponse> createNewClaimWithHttpInfo(String legalPersonId, ClaimsCreateNewClaimRequest claimsCreateNewClaimRequest) throws ApiException {
        okhttp3.Call localVarCall = createNewClaimValidateBeforeCall(legalPersonId, claimsCreateNewClaimRequest, null);
        Type localVarReturnType = new TypeToken<ClaimsCreateNewClaimResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewClaimAsync(String legalPersonId, ClaimsCreateNewClaimRequest claimsCreateNewClaimRequest, final ApiCallback<ClaimsCreateNewClaimResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewClaimValidateBeforeCall(legalPersonId, claimsCreateNewClaimRequest, _callback);
        Type localVarReturnType = new TypeToken<ClaimsCreateNewClaimResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewClaimRequestBuilder {
        private final String claimType;
        private final String legalPersonId;
        private Object mobileNumber;
        private LocalDate dateOfBirth;
        private String givenName;
        private String surname;
        private String middleName;
        private String tradingName;
        private BothBuildingNameAndBuildingNumberProperty tradingAddress;
        private Object emailAddress;
        private String city;
        private String buildingName;
        private String streetName;
        private String entityName;
        private String postalCode;
        private String corporationType;
        private Object telephoneNumber;
        private String buildingNumber;
        private Object countryCode;
        private LocalDate dateOfIncorporation;
        private String entityRegistrationNumber;
        private IncomeProperty income;
        private InitialDepositProperty initialDeposit;
        private List<Object> internationalPaymentsCountries;
        private String legalPersonUrl;
        private String ownershipPercent;
        private String companiesHouseUrl;
        private Boolean seniorManagerQuestionMark;
        private Object taxResidency;
        private List<String> ukRegulatoryPermissions;
        private String businessDescription;
        private Set<String> individualSourcesOfFunds;
        private BothBuildingNameAndBuildingNumberProperty businessAddress;
        private AnnualTurnoverProperty annualTurnover;
        private Set<String> purposesOfAccount;
        private List<String> sicCodes;
        private List<Object> internationalOperationsCountries;
        private Set<String> sourcesOfFunds;
        private Set<String> relianceVerificationMethods;
        private String relianceVerificationStandard;
        private String businessName;
        private Set<String> individualPurposesOfAccount;
        private Object nationality;
        private String socialMedia;
        private String websiteUrl;
        private String taxIdentificationNumber;

        private CreateNewClaimRequestBuilder(String claimType, String legalPersonId) {
            this.claimType = claimType;
            this.legalPersonId = legalPersonId;
        }

        /**
         * Set mobileNumber
         * @param mobileNumber  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder mobileNumber(Object mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }
        
        /**
         * Set dateOfBirth
         * @param dateOfBirth ISO 8601 formatted date. (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        
        /**
         * Set givenName
         * @param givenName  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }
        
        /**
         * Set surname
         * @param surname  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }
        
        /**
         * Set middleName
         * @param middleName  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }
        
        /**
         * Set tradingName
         * @param tradingName  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder tradingName(String tradingName) {
            this.tradingName = tradingName;
            return this;
        }
        
        /**
         * Set tradingAddress
         * @param tradingAddress  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder tradingAddress(BothBuildingNameAndBuildingNumberProperty tradingAddress) {
            this.tradingAddress = tradingAddress;
            return this;
        }
        
        /**
         * Set emailAddress
         * @param emailAddress  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder emailAddress(Object emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
        
        /**
         * Set city
         * @param city  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder city(String city) {
            this.city = city;
            return this;
        }
        
        /**
         * Set buildingName
         * @param buildingName  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder buildingName(String buildingName) {
            this.buildingName = buildingName;
            return this;
        }
        
        /**
         * Set streetName
         * @param streetName  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }
        
        /**
         * Set entityName
         * @param entityName  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder entityName(String entityName) {
            this.entityName = entityName;
            return this;
        }
        
        /**
         * Set postalCode
         * @param postalCode  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }
        
        /**
         * Set corporationType
         * @param corporationType  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder corporationType(String corporationType) {
            this.corporationType = corporationType;
            return this;
        }
        
        /**
         * Set telephoneNumber
         * @param telephoneNumber  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder telephoneNumber(Object telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }
        
        /**
         * Set buildingNumber
         * @param buildingNumber  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder buildingNumber(String buildingNumber) {
            this.buildingNumber = buildingNumber;
            return this;
        }
        
        /**
         * Set countryCode
         * @param countryCode  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder countryCode(Object countryCode) {
            this.countryCode = countryCode;
            return this;
        }
        
        /**
         * Set dateOfIncorporation
         * @param dateOfIncorporation ISO 8601 formatted date. (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder dateOfIncorporation(LocalDate dateOfIncorporation) {
            this.dateOfIncorporation = dateOfIncorporation;
            return this;
        }
        
        /**
         * Set entityRegistrationNumber
         * @param entityRegistrationNumber The entity number assigned by the local register. For UK companies that&#39;s the Companies House company number. (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder entityRegistrationNumber(String entityRegistrationNumber) {
            this.entityRegistrationNumber = entityRegistrationNumber;
            return this;
        }
        
        /**
         * Set income
         * @param income  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder income(IncomeProperty income) {
            this.income = income;
            return this;
        }
        
        /**
         * Set initialDeposit
         * @param initialDeposit  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder initialDeposit(InitialDepositProperty initialDeposit) {
            this.initialDeposit = initialDeposit;
            return this;
        }
        
        /**
         * Set internationalPaymentsCountries
         * @param internationalPaymentsCountries  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder internationalPaymentsCountries(List<Object> internationalPaymentsCountries) {
            this.internationalPaymentsCountries = internationalPaymentsCountries;
            return this;
        }
        
        /**
         * Set legalPersonUrl
         * @param legalPersonUrl A contextual link to the [legal person](http://docs.griffin.com). (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder legalPersonUrl(String legalPersonUrl) {
            this.legalPersonUrl = legalPersonUrl;
            return this;
        }
        
        /**
         * Set ownershipPercent
         * @param ownershipPercent The percentage ownership the legal person has of the corporation. (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder ownershipPercent(String ownershipPercent) {
            this.ownershipPercent = ownershipPercent;
            return this;
        }
        
        /**
         * Set companiesHouseUrl
         * @param companiesHouseUrl The URL of the entity in Companies House (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder companiesHouseUrl(String companiesHouseUrl) {
            this.companiesHouseUrl = companiesHouseUrl;
            return this;
        }
        
        /**
         * Set seniorManagerQuestionMark
         * @param seniorManagerQuestionMark  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder seniorManagerQuestionMark(Boolean seniorManagerQuestionMark) {
            this.seniorManagerQuestionMark = seniorManagerQuestionMark;
            return this;
        }
        
        /**
         * Set taxResidency
         * @param taxResidency ISO 3166-1 alpha-2 two-letter country code. (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder taxResidency(Object taxResidency) {
            this.taxResidency = taxResidency;
            return this;
        }
        
        /**
         * Set ukRegulatoryPermissions
         * @param ukRegulatoryPermissions  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder ukRegulatoryPermissions(List<String> ukRegulatoryPermissions) {
            this.ukRegulatoryPermissions = ukRegulatoryPermissions;
            return this;
        }
        
        /**
         * Set businessDescription
         * @param businessDescription  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder businessDescription(String businessDescription) {
            this.businessDescription = businessDescription;
            return this;
        }
        
        /**
         * Set individualSourcesOfFunds
         * @param individualSourcesOfFunds  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder individualSourcesOfFunds(Set<String> individualSourcesOfFunds) {
            this.individualSourcesOfFunds = individualSourcesOfFunds;
            return this;
        }
        
        /**
         * Set businessAddress
         * @param businessAddress  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder businessAddress(BothBuildingNameAndBuildingNumberProperty businessAddress) {
            this.businessAddress = businessAddress;
            return this;
        }
        
        /**
         * Set annualTurnover
         * @param annualTurnover  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder annualTurnover(AnnualTurnoverProperty annualTurnover) {
            this.annualTurnover = annualTurnover;
            return this;
        }
        
        /**
         * Set purposesOfAccount
         * @param purposesOfAccount  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder purposesOfAccount(Set<String> purposesOfAccount) {
            this.purposesOfAccount = purposesOfAccount;
            return this;
        }
        
        /**
         * Set sicCodes
         * @param sicCodes  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder sicCodes(List<String> sicCodes) {
            this.sicCodes = sicCodes;
            return this;
        }
        
        /**
         * Set internationalOperationsCountries
         * @param internationalOperationsCountries  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder internationalOperationsCountries(List<Object> internationalOperationsCountries) {
            this.internationalOperationsCountries = internationalOperationsCountries;
            return this;
        }
        
        /**
         * Set sourcesOfFunds
         * @param sourcesOfFunds  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder sourcesOfFunds(Set<String> sourcesOfFunds) {
            this.sourcesOfFunds = sourcesOfFunds;
            return this;
        }
        
        /**
         * Set relianceVerificationMethods
         * @param relianceVerificationMethods  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder relianceVerificationMethods(Set<String> relianceVerificationMethods) {
            this.relianceVerificationMethods = relianceVerificationMethods;
            return this;
        }
        
        /**
         * Set relianceVerificationStandard
         * @param relianceVerificationStandard  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder relianceVerificationStandard(String relianceVerificationStandard) {
            this.relianceVerificationStandard = relianceVerificationStandard;
            return this;
        }
        
        /**
         * Set businessName
         * @param businessName  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder businessName(String businessName) {
            this.businessName = businessName;
            return this;
        }
        
        /**
         * Set individualPurposesOfAccount
         * @param individualPurposesOfAccount  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder individualPurposesOfAccount(Set<String> individualPurposesOfAccount) {
            this.individualPurposesOfAccount = individualPurposesOfAccount;
            return this;
        }
        
        /**
         * Set nationality
         * @param nationality ISO 3166-1 alpha-2 two-letter country code. (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder nationality(Object nationality) {
            this.nationality = nationality;
            return this;
        }
        
        /**
         * Set socialMedia
         * @param socialMedia  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder socialMedia(String socialMedia) {
            this.socialMedia = socialMedia;
            return this;
        }
        
        /**
         * Set websiteUrl
         * @param websiteUrl  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder websiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
            return this;
        }
        
        /**
         * Set taxIdentificationNumber
         * @param taxIdentificationNumber  (optional)
         * @return CreateNewClaimRequestBuilder
         */
        public CreateNewClaimRequestBuilder taxIdentificationNumber(String taxIdentificationNumber) {
            this.taxIdentificationNumber = taxIdentificationNumber;
            return this;
        }
        
        /**
         * Build call for createNewClaim
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            ClaimsCreateNewClaimRequest claimsCreateNewClaimRequest = buildBodyParams();
            return createNewClaimCall(legalPersonId, claimsCreateNewClaimRequest, _callback);
        }

        private ClaimsCreateNewClaimRequest buildBodyParams() {
            ClaimsCreateNewClaimRequest claimsCreateNewClaimRequest = new ClaimsCreateNewClaimRequest();
            claimsCreateNewClaimRequest.mobileNumber(this.mobileNumber);
            if (this.claimType != null)
            claimsCreateNewClaimRequest.claimType(ClaimsCreateNewClaimRequest.ClaimTypeEnum.fromValue(this.claimType));
            claimsCreateNewClaimRequest.dateOfBirth(this.dateOfBirth);
            claimsCreateNewClaimRequest.givenName(this.givenName);
            claimsCreateNewClaimRequest.surname(this.surname);
            claimsCreateNewClaimRequest.middleName(this.middleName);
            claimsCreateNewClaimRequest.tradingName(this.tradingName);
            claimsCreateNewClaimRequest.tradingAddress(this.tradingAddress);
            claimsCreateNewClaimRequest.emailAddress(this.emailAddress);
            claimsCreateNewClaimRequest.city(this.city);
            claimsCreateNewClaimRequest.buildingName(this.buildingName);
            claimsCreateNewClaimRequest.streetName(this.streetName);
            claimsCreateNewClaimRequest.entityName(this.entityName);
            claimsCreateNewClaimRequest.postalCode(this.postalCode);
            if (this.corporationType != null)
            claimsCreateNewClaimRequest.corporationType(ClaimsCreateNewClaimRequest.CorporationTypeEnum.fromValue(this.corporationType));
            claimsCreateNewClaimRequest.telephoneNumber(this.telephoneNumber);
            claimsCreateNewClaimRequest.buildingNumber(this.buildingNumber);
            claimsCreateNewClaimRequest.countryCode(this.countryCode);
            claimsCreateNewClaimRequest.dateOfIncorporation(this.dateOfIncorporation);
            claimsCreateNewClaimRequest.entityRegistrationNumber(this.entityRegistrationNumber);
            claimsCreateNewClaimRequest.income(this.income);
            claimsCreateNewClaimRequest.initialDeposit(this.initialDeposit);
            claimsCreateNewClaimRequest.internationalPaymentsCountries(this.internationalPaymentsCountries);
            claimsCreateNewClaimRequest.legalPersonUrl(this.legalPersonUrl);
            claimsCreateNewClaimRequest.ownershipPercent(this.ownershipPercent);
            claimsCreateNewClaimRequest.companiesHouseUrl(this.companiesHouseUrl);
            claimsCreateNewClaimRequest.seniorManagerQuestionMark(this.seniorManagerQuestionMark);
            claimsCreateNewClaimRequest.taxResidency(this.taxResidency);
            if (this.ukRegulatoryPermissions != null)
            claimsCreateNewClaimRequest.ukRegulatoryPermissions(ClaimsCreateNewClaimRequest.UkRegulatoryPermissionsEnum.fromValue(this.ukRegulatoryPermissions));
            claimsCreateNewClaimRequest.businessDescription(this.businessDescription);
            if (this.individualSourcesOfFunds != null)
            claimsCreateNewClaimRequest.individualSourcesOfFunds(ClaimsCreateNewClaimRequest.IndividualSourcesOfFundsEnum.fromValue(this.individualSourcesOfFunds));
            claimsCreateNewClaimRequest.businessAddress(this.businessAddress);
            claimsCreateNewClaimRequest.annualTurnover(this.annualTurnover);
            if (this.purposesOfAccount != null)
            claimsCreateNewClaimRequest.purposesOfAccount(ClaimsCreateNewClaimRequest.PurposesOfAccountEnum.fromValue(this.purposesOfAccount));
            claimsCreateNewClaimRequest.sicCodes(this.sicCodes);
            claimsCreateNewClaimRequest.internationalOperationsCountries(this.internationalOperationsCountries);
            if (this.sourcesOfFunds != null)
            claimsCreateNewClaimRequest.sourcesOfFunds(ClaimsCreateNewClaimRequest.SourcesOfFundsEnum.fromValue(this.sourcesOfFunds));
            if (this.relianceVerificationMethods != null)
            claimsCreateNewClaimRequest.relianceVerificationMethods(ClaimsCreateNewClaimRequest.RelianceVerificationMethodsEnum.fromValue(this.relianceVerificationMethods));
            if (this.relianceVerificationStandard != null)
            claimsCreateNewClaimRequest.relianceVerificationStandard(ClaimsCreateNewClaimRequest.RelianceVerificationStandardEnum.fromValue(this.relianceVerificationStandard));
            claimsCreateNewClaimRequest.businessName(this.businessName);
            if (this.individualPurposesOfAccount != null)
            claimsCreateNewClaimRequest.individualPurposesOfAccount(ClaimsCreateNewClaimRequest.IndividualPurposesOfAccountEnum.fromValue(this.individualPurposesOfAccount));
            claimsCreateNewClaimRequest.nationality(this.nationality);
            claimsCreateNewClaimRequest.socialMedia(this.socialMedia);
            claimsCreateNewClaimRequest.websiteUrl(this.websiteUrl);
            claimsCreateNewClaimRequest.taxIdentificationNumber(this.taxIdentificationNumber);
            return claimsCreateNewClaimRequest;
        }

        /**
         * Execute createNewClaim request
         * @return ClaimsCreateNewClaimResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ClaimsCreateNewClaimResponse execute() throws ApiException {
            ClaimsCreateNewClaimRequest claimsCreateNewClaimRequest = buildBodyParams();
            ApiResponse<ClaimsCreateNewClaimResponse> localVarResp = createNewClaimWithHttpInfo(legalPersonId, claimsCreateNewClaimRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNewClaim request with HTTP info returned
         * @return ApiResponse&lt;ClaimsCreateNewClaimResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<ClaimsCreateNewClaimResponse> executeWithHttpInfo() throws ApiException {
            ClaimsCreateNewClaimRequest claimsCreateNewClaimRequest = buildBodyParams();
            return createNewClaimWithHttpInfo(legalPersonId, claimsCreateNewClaimRequest);
        }

        /**
         * Execute createNewClaim request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ClaimsCreateNewClaimResponse> _callback) throws ApiException {
            ClaimsCreateNewClaimRequest claimsCreateNewClaimRequest = buildBodyParams();
            return createNewClaimAsync(legalPersonId, claimsCreateNewClaimRequest, _callback);
        }
    }

    /**
     * Create claim
     * Creates a new claim about a Legal Person.
     * @param legalPersonId  (required)
     * @param claimsCreateNewClaimRequest  (required)
     * @return CreateNewClaimRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public CreateNewClaimRequestBuilder createNewClaim(String claimType, String legalPersonId) throws IllegalArgumentException {
        if (claimType == null) throw new IllegalArgumentException("\"claimType\" is required but got null");
            

        if (legalPersonId == null) throw new IllegalArgumentException("\"legalPersonId\" is required but got null");
            

        return new CreateNewClaimRequestBuilder(claimType, legalPersonId);
    }
    private okhttp3.Call getAllClaimsCall(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v0/legal-persons/{legal-person-id}/claims"
            .replace("{" + "legal-person-id" + "}", localVarApiClient.escapeString(legalPersonId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (sort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort", sort));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[size]", pageSize));
        }

        if (pageAfter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[after]", pageAfter));
        }

        if (pageBefore != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[before]", pageBefore));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "api-key-auth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getAllClaimsValidateBeforeCall(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'legalPersonId' is set
        if (legalPersonId == null) {
            throw new ApiException("Missing the required parameter 'legalPersonId' when calling getAllClaims(Async)");
        }

        return getAllClaimsCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);

    }


    private ApiResponse<ClaimsGetAllClaimsResponse> getAllClaimsWithHttpInfo(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore) throws ApiException {
        okhttp3.Call localVarCall = getAllClaimsValidateBeforeCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, null);
        Type localVarReturnType = new TypeToken<ClaimsGetAllClaimsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getAllClaimsAsync(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback<ClaimsGetAllClaimsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAllClaimsValidateBeforeCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);
        Type localVarReturnType = new TypeToken<ClaimsGetAllClaimsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetAllClaimsRequestBuilder {
        private final String legalPersonId;
        private String sort;
        private Long pageSize;
        private byte[] pageAfter;
        private byte[] pageBefore;

        private GetAllClaimsRequestBuilder(String legalPersonId) {
            this.legalPersonId = legalPersonId;
        }

        /**
         * Set sort
         * @param sort  (optional)
         * @return GetAllClaimsRequestBuilder
         */
        public GetAllClaimsRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return GetAllClaimsRequestBuilder
         */
        public GetAllClaimsRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return GetAllClaimsRequestBuilder
         */
        public GetAllClaimsRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return GetAllClaimsRequestBuilder
         */
        public GetAllClaimsRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Build call for getAllClaims
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getAllClaimsCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);
        }


        /**
         * Execute getAllClaims request
         * @return ClaimsGetAllClaimsResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ClaimsGetAllClaimsResponse execute() throws ApiException {
            ApiResponse<ClaimsGetAllClaimsResponse> localVarResp = getAllClaimsWithHttpInfo(legalPersonId, sort, pageSize, pageAfter, pageBefore);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getAllClaims request with HTTP info returned
         * @return ApiResponse&lt;ClaimsGetAllClaimsResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<ClaimsGetAllClaimsResponse> executeWithHttpInfo() throws ApiException {
            return getAllClaimsWithHttpInfo(legalPersonId, sort, pageSize, pageAfter, pageBefore);
        }

        /**
         * Execute getAllClaims request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ClaimsGetAllClaimsResponse> _callback) throws ApiException {
            return getAllClaimsAsync(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);
        }
    }

    /**
     * List claims
     * Yields a list of all current claims about this Legal Person.
     * @param legalPersonId  (required)
     * @return GetAllClaimsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetAllClaimsRequestBuilder getAllClaims(String legalPersonId) throws IllegalArgumentException {
        if (legalPersonId == null) throw new IllegalArgumentException("\"legalPersonId\" is required but got null");
            

        return new GetAllClaimsRequestBuilder(legalPersonId);
    }
}
