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


import com.konfigthis.client.model.LegalPersonsCreateNewLegalPersonRequest;
import com.konfigthis.client.model.LegalPersonsCreateNewLegalPersonResponse;
import com.konfigthis.client.model.LegalPersonsGetLegalPersonResponse;
import com.konfigthis.client.model.LegalPersonsListLegalPersonsResponse;
import com.konfigthis.client.model.LegalPersonsUpdateLegalPersonRequest;
import com.konfigthis.client.model.LegalPersonsUpdateLegalPersonResponse;
import com.konfigthis.client.model.MobileNumber;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class LegalPersonsApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public LegalPersonsApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public LegalPersonsApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createNewLegalPersonCall(String organizationId, LegalPersonsCreateNewLegalPersonRequest legalPersonsCreateNewLegalPersonRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = legalPersonsCreateNewLegalPersonRequest;

        // create path and map variables
        String localVarPath = "/v0/organizations/{organization-id}/legal-persons"
            .replace("{" + "organization-id" + "}", localVarApiClient.escapeString(organizationId.toString()));

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
    private okhttp3.Call createNewLegalPersonValidateBeforeCall(String organizationId, LegalPersonsCreateNewLegalPersonRequest legalPersonsCreateNewLegalPersonRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling createNewLegalPerson(Async)");
        }

        // verify the required parameter 'legalPersonsCreateNewLegalPersonRequest' is set
        if (legalPersonsCreateNewLegalPersonRequest == null) {
            throw new ApiException("Missing the required parameter 'legalPersonsCreateNewLegalPersonRequest' when calling createNewLegalPerson(Async)");
        }

        return createNewLegalPersonCall(organizationId, legalPersonsCreateNewLegalPersonRequest, _callback);

    }


    private ApiResponse<LegalPersonsCreateNewLegalPersonResponse> createNewLegalPersonWithHttpInfo(String organizationId, LegalPersonsCreateNewLegalPersonRequest legalPersonsCreateNewLegalPersonRequest) throws ApiException {
        okhttp3.Call localVarCall = createNewLegalPersonValidateBeforeCall(organizationId, legalPersonsCreateNewLegalPersonRequest, null);
        Type localVarReturnType = new TypeToken<LegalPersonsCreateNewLegalPersonResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewLegalPersonAsync(String organizationId, LegalPersonsCreateNewLegalPersonRequest legalPersonsCreateNewLegalPersonRequest, final ApiCallback<LegalPersonsCreateNewLegalPersonResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewLegalPersonValidateBeforeCall(organizationId, legalPersonsCreateNewLegalPersonRequest, _callback);
        Type localVarReturnType = new TypeToken<LegalPersonsCreateNewLegalPersonResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewLegalPersonRequestBuilder {
        private final String displayName;
        private final String legalPersonType;
        private final String organizationId;
        private List<MobileNumber> claims;

        private CreateNewLegalPersonRequestBuilder(String displayName, String legalPersonType, String organizationId) {
            this.displayName = displayName;
            this.legalPersonType = legalPersonType;
            this.organizationId = organizationId;
        }

        /**
         * Set claims
         * @param claims  (optional)
         * @return CreateNewLegalPersonRequestBuilder
         */
        public CreateNewLegalPersonRequestBuilder claims(List<MobileNumber> claims) {
            this.claims = claims;
            return this;
        }
        
        /**
         * Build call for createNewLegalPerson
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            LegalPersonsCreateNewLegalPersonRequest legalPersonsCreateNewLegalPersonRequest = buildBodyParams();
            return createNewLegalPersonCall(organizationId, legalPersonsCreateNewLegalPersonRequest, _callback);
        }

        private LegalPersonsCreateNewLegalPersonRequest buildBodyParams() {
            LegalPersonsCreateNewLegalPersonRequest legalPersonsCreateNewLegalPersonRequest = new LegalPersonsCreateNewLegalPersonRequest();
            legalPersonsCreateNewLegalPersonRequest.displayName(this.displayName);
            if (this.legalPersonType != null)
            legalPersonsCreateNewLegalPersonRequest.legalPersonType(LegalPersonsCreateNewLegalPersonRequest.LegalPersonTypeEnum.fromValue(this.legalPersonType));
            legalPersonsCreateNewLegalPersonRequest.claims(this.claims);
            return legalPersonsCreateNewLegalPersonRequest;
        }

        /**
         * Execute createNewLegalPerson request
         * @return LegalPersonsCreateNewLegalPersonResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public LegalPersonsCreateNewLegalPersonResponse execute() throws ApiException {
            LegalPersonsCreateNewLegalPersonRequest legalPersonsCreateNewLegalPersonRequest = buildBodyParams();
            ApiResponse<LegalPersonsCreateNewLegalPersonResponse> localVarResp = createNewLegalPersonWithHttpInfo(organizationId, legalPersonsCreateNewLegalPersonRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNewLegalPerson request with HTTP info returned
         * @return ApiResponse&lt;LegalPersonsCreateNewLegalPersonResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<LegalPersonsCreateNewLegalPersonResponse> executeWithHttpInfo() throws ApiException {
            LegalPersonsCreateNewLegalPersonRequest legalPersonsCreateNewLegalPersonRequest = buildBodyParams();
            return createNewLegalPersonWithHttpInfo(organizationId, legalPersonsCreateNewLegalPersonRequest);
        }

        /**
         * Execute createNewLegalPerson request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<LegalPersonsCreateNewLegalPersonResponse> _callback) throws ApiException {
            LegalPersonsCreateNewLegalPersonRequest legalPersonsCreateNewLegalPersonRequest = buildBodyParams();
            return createNewLegalPersonAsync(organizationId, legalPersonsCreateNewLegalPersonRequest, _callback);
        }
    }

    /**
     * Create legal person
     * Creates a new Legal Person. A collection of [Claims](http://docs.griffin.com) may be provided.
     * @param organizationId  (required)
     * @param legalPersonsCreateNewLegalPersonRequest  (required)
     * @return CreateNewLegalPersonRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public CreateNewLegalPersonRequestBuilder createNewLegalPerson(String displayName, String legalPersonType, String organizationId) throws IllegalArgumentException {
        if (displayName == null) throw new IllegalArgumentException("\"displayName\" is required but got null");
            if (displayName != null && displayName.length() < 1) {
              throw new IllegalArgumentException("Invalid value for displayName. Length must be greater than or equal to 1.");
            }

        if (legalPersonType == null) throw new IllegalArgumentException("\"legalPersonType\" is required but got null");
            

        if (organizationId == null) throw new IllegalArgumentException("\"organizationId\" is required but got null");
            

        return new CreateNewLegalPersonRequestBuilder(displayName, legalPersonType, organizationId);
    }
    private okhttp3.Call getLegalPersonCall(String legalPersonId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/legal-persons/{legal-person-id}"
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
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "api-key-auth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getLegalPersonValidateBeforeCall(String legalPersonId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'legalPersonId' is set
        if (legalPersonId == null) {
            throw new ApiException("Missing the required parameter 'legalPersonId' when calling getLegalPerson(Async)");
        }

        return getLegalPersonCall(legalPersonId, _callback);

    }


    private ApiResponse<LegalPersonsGetLegalPersonResponse> getLegalPersonWithHttpInfo(String legalPersonId) throws ApiException {
        okhttp3.Call localVarCall = getLegalPersonValidateBeforeCall(legalPersonId, null);
        Type localVarReturnType = new TypeToken<LegalPersonsGetLegalPersonResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getLegalPersonAsync(String legalPersonId, final ApiCallback<LegalPersonsGetLegalPersonResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getLegalPersonValidateBeforeCall(legalPersonId, _callback);
        Type localVarReturnType = new TypeToken<LegalPersonsGetLegalPersonResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetLegalPersonRequestBuilder {
        private final String legalPersonId;

        private GetLegalPersonRequestBuilder(String legalPersonId) {
            this.legalPersonId = legalPersonId;
        }

        /**
         * Build call for getLegalPerson
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
            return getLegalPersonCall(legalPersonId, _callback);
        }


        /**
         * Execute getLegalPerson request
         * @return LegalPersonsGetLegalPersonResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public LegalPersonsGetLegalPersonResponse execute() throws ApiException {
            ApiResponse<LegalPersonsGetLegalPersonResponse> localVarResp = getLegalPersonWithHttpInfo(legalPersonId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getLegalPerson request with HTTP info returned
         * @return ApiResponse&lt;LegalPersonsGetLegalPersonResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<LegalPersonsGetLegalPersonResponse> executeWithHttpInfo() throws ApiException {
            return getLegalPersonWithHttpInfo(legalPersonId);
        }

        /**
         * Execute getLegalPerson request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<LegalPersonsGetLegalPersonResponse> _callback) throws ApiException {
            return getLegalPersonAsync(legalPersonId, _callback);
        }
    }

    /**
     * Get legal person
     * Yields the legal-person.
     * @param legalPersonId  (required)
     * @return GetLegalPersonRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetLegalPersonRequestBuilder getLegalPerson(String legalPersonId) throws IllegalArgumentException {
        if (legalPersonId == null) throw new IllegalArgumentException("\"legalPersonId\" is required but got null");
            

        return new GetLegalPersonRequestBuilder(legalPersonId);
    }
    private okhttp3.Call listLegalPersonsCall(String organizationId, String sort, List<String> include, String filterApplicationStatusEq, List<String> filterHas, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/organizations/{organization-id}/legal-persons"
            .replace("{" + "organization-id" + "}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (sort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort", sort));
        }

        if (include != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("csv", "include", include));
        }

        if (filterApplicationStatusEq != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[application-status][eq]", filterApplicationStatusEq));
        }

        if (filterHas != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("csv", "filter[has][]", filterHas));
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
    private okhttp3.Call listLegalPersonsValidateBeforeCall(String organizationId, String sort, List<String> include, String filterApplicationStatusEq, List<String> filterHas, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling listLegalPersons(Async)");
        }

        return listLegalPersonsCall(organizationId, sort, include, filterApplicationStatusEq, filterHas, pageSize, pageAfter, pageBefore, _callback);

    }


    private ApiResponse<LegalPersonsListLegalPersonsResponse> listLegalPersonsWithHttpInfo(String organizationId, String sort, List<String> include, String filterApplicationStatusEq, List<String> filterHas, Long pageSize, byte[] pageAfter, byte[] pageBefore) throws ApiException {
        okhttp3.Call localVarCall = listLegalPersonsValidateBeforeCall(organizationId, sort, include, filterApplicationStatusEq, filterHas, pageSize, pageAfter, pageBefore, null);
        Type localVarReturnType = new TypeToken<LegalPersonsListLegalPersonsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listLegalPersonsAsync(String organizationId, String sort, List<String> include, String filterApplicationStatusEq, List<String> filterHas, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback<LegalPersonsListLegalPersonsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listLegalPersonsValidateBeforeCall(organizationId, sort, include, filterApplicationStatusEq, filterHas, pageSize, pageAfter, pageBefore, _callback);
        Type localVarReturnType = new TypeToken<LegalPersonsListLegalPersonsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListLegalPersonsRequestBuilder {
        private final String organizationId;
        private String sort;
        private List<String> include;
        private String filterApplicationStatusEq;
        private List<String> filterHas;
        private Long pageSize;
        private byte[] pageAfter;
        private byte[] pageBefore;

        private ListLegalPersonsRequestBuilder(String organizationId) {
            this.organizationId = organizationId;
        }

        /**
         * Set sort
         * @param sort  (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }
        
        /**
         * Set include
         * @param include For each legal person returned, include its latest verification (if one exists), and/or its latest risk rating (if one exists) in the response under the &#x60;included&#x60; attribute. (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder include(List<String> include) {
            this.include = include;
            return this;
        }
        
        /**
         * Set filterApplicationStatusEq
         * @param filterApplicationStatusEq Return only legal persons with the given application-status. (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder filterApplicationStatusEq(String filterApplicationStatusEq) {
            this.filterApplicationStatusEq = filterApplicationStatusEq;
            return this;
        }
        
        /**
         * Set filterHas
         * @param filterHas Return only legal persons with the given attributes. (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder filterHas(List<String> filterHas) {
            this.filterHas = filterHas;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Build call for listLegalPersons
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
            return listLegalPersonsCall(organizationId, sort, include, filterApplicationStatusEq, filterHas, pageSize, pageAfter, pageBefore, _callback);
        }


        /**
         * Execute listLegalPersons request
         * @return LegalPersonsListLegalPersonsResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public LegalPersonsListLegalPersonsResponse execute() throws ApiException {
            ApiResponse<LegalPersonsListLegalPersonsResponse> localVarResp = listLegalPersonsWithHttpInfo(organizationId, sort, include, filterApplicationStatusEq, filterHas, pageSize, pageAfter, pageBefore);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listLegalPersons request with HTTP info returned
         * @return ApiResponse&lt;LegalPersonsListLegalPersonsResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<LegalPersonsListLegalPersonsResponse> executeWithHttpInfo() throws ApiException {
            return listLegalPersonsWithHttpInfo(organizationId, sort, include, filterApplicationStatusEq, filterHas, pageSize, pageAfter, pageBefore);
        }

        /**
         * Execute listLegalPersons request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<LegalPersonsListLegalPersonsResponse> _callback) throws ApiException {
            return listLegalPersonsAsync(organizationId, sort, include, filterApplicationStatusEq, filterHas, pageSize, pageAfter, pageBefore, _callback);
        }
    }

    /**
     * List legal persons
     * Returns a paginated list of all legal persons for the given organization.  By default, results are sorted descending by &#x60;created-at&#x60; (newest first). To sort ascending by &#x60;created-at&#x60;, provide a &#x60;?sort&#x3D;created-at&#x60; query parameter. 
     * @param organizationId  (required)
     * @return ListLegalPersonsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ListLegalPersonsRequestBuilder listLegalPersons(String organizationId) throws IllegalArgumentException {
        if (organizationId == null) throw new IllegalArgumentException("\"organizationId\" is required but got null");
            

        return new ListLegalPersonsRequestBuilder(organizationId);
    }
    private okhttp3.Call updateLegalPersonCall(String legalPersonId, LegalPersonsUpdateLegalPersonRequest legalPersonsUpdateLegalPersonRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = legalPersonsUpdateLegalPersonRequest;

        // create path and map variables
        String localVarPath = "/v0/legal-persons/{legal-person-id}"
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
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateLegalPersonValidateBeforeCall(String legalPersonId, LegalPersonsUpdateLegalPersonRequest legalPersonsUpdateLegalPersonRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'legalPersonId' is set
        if (legalPersonId == null) {
            throw new ApiException("Missing the required parameter 'legalPersonId' when calling updateLegalPerson(Async)");
        }

        // verify the required parameter 'legalPersonsUpdateLegalPersonRequest' is set
        if (legalPersonsUpdateLegalPersonRequest == null) {
            throw new ApiException("Missing the required parameter 'legalPersonsUpdateLegalPersonRequest' when calling updateLegalPerson(Async)");
        }

        return updateLegalPersonCall(legalPersonId, legalPersonsUpdateLegalPersonRequest, _callback);

    }


    private ApiResponse<LegalPersonsUpdateLegalPersonResponse> updateLegalPersonWithHttpInfo(String legalPersonId, LegalPersonsUpdateLegalPersonRequest legalPersonsUpdateLegalPersonRequest) throws ApiException {
        okhttp3.Call localVarCall = updateLegalPersonValidateBeforeCall(legalPersonId, legalPersonsUpdateLegalPersonRequest, null);
        Type localVarReturnType = new TypeToken<LegalPersonsUpdateLegalPersonResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateLegalPersonAsync(String legalPersonId, LegalPersonsUpdateLegalPersonRequest legalPersonsUpdateLegalPersonRequest, final ApiCallback<LegalPersonsUpdateLegalPersonResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateLegalPersonValidateBeforeCall(legalPersonId, legalPersonsUpdateLegalPersonRequest, _callback);
        Type localVarReturnType = new TypeToken<LegalPersonsUpdateLegalPersonResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateLegalPersonRequestBuilder {
        private final String displayName;
        private final String legalPersonId;

        private UpdateLegalPersonRequestBuilder(String displayName, String legalPersonId) {
            this.displayName = displayName;
            this.legalPersonId = legalPersonId;
        }

        /**
         * Build call for updateLegalPerson
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            LegalPersonsUpdateLegalPersonRequest legalPersonsUpdateLegalPersonRequest = buildBodyParams();
            return updateLegalPersonCall(legalPersonId, legalPersonsUpdateLegalPersonRequest, _callback);
        }

        private LegalPersonsUpdateLegalPersonRequest buildBodyParams() {
            LegalPersonsUpdateLegalPersonRequest legalPersonsUpdateLegalPersonRequest = new LegalPersonsUpdateLegalPersonRequest();
            legalPersonsUpdateLegalPersonRequest.displayName(this.displayName);
            return legalPersonsUpdateLegalPersonRequest;
        }

        /**
         * Execute updateLegalPerson request
         * @return LegalPersonsUpdateLegalPersonResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public LegalPersonsUpdateLegalPersonResponse execute() throws ApiException {
            LegalPersonsUpdateLegalPersonRequest legalPersonsUpdateLegalPersonRequest = buildBodyParams();
            ApiResponse<LegalPersonsUpdateLegalPersonResponse> localVarResp = updateLegalPersonWithHttpInfo(legalPersonId, legalPersonsUpdateLegalPersonRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateLegalPerson request with HTTP info returned
         * @return ApiResponse&lt;LegalPersonsUpdateLegalPersonResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<LegalPersonsUpdateLegalPersonResponse> executeWithHttpInfo() throws ApiException {
            LegalPersonsUpdateLegalPersonRequest legalPersonsUpdateLegalPersonRequest = buildBodyParams();
            return updateLegalPersonWithHttpInfo(legalPersonId, legalPersonsUpdateLegalPersonRequest);
        }

        /**
         * Execute updateLegalPerson request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<LegalPersonsUpdateLegalPersonResponse> _callback) throws ApiException {
            LegalPersonsUpdateLegalPersonRequest legalPersonsUpdateLegalPersonRequest = buildBodyParams();
            return updateLegalPersonAsync(legalPersonId, legalPersonsUpdateLegalPersonRequest, _callback);
        }
    }

    /**
     * Update legal person
     * Updates the legal-person.
     * @param legalPersonId  (required)
     * @param legalPersonsUpdateLegalPersonRequest  (required)
     * @return UpdateLegalPersonRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
        <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public UpdateLegalPersonRequestBuilder updateLegalPerson(String displayName, String legalPersonId) throws IllegalArgumentException {
        if (displayName == null) throw new IllegalArgumentException("\"displayName\" is required but got null");
            if (displayName != null && displayName.length() < 1) {
              throw new IllegalArgumentException("Invalid value for displayName. Length must be greater than or equal to 1.");
            }

        if (legalPersonId == null) throw new IllegalArgumentException("\"legalPersonId\" is required but got null");
            

        return new UpdateLegalPersonRequestBuilder(displayName, legalPersonId);
    }
}
