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


import com.konfigthis.client.model.PayeesGetDetailsResponse;
import com.konfigthis.client.model.PayeesListLegalPersonPayeesResponse;
import com.konfigthis.client.model.PayeesRegisterNewPayeeRequest;
import com.konfigthis.client.model.PayeesRegisterNewPayeeResponse;
import com.konfigthis.client.model.PayeesUpdatePayeeRequest;
import com.konfigthis.client.model.PayeesUpdatePayeeResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class PayeesApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PayeesApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public PayeesApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call getDetailsCall(String payeeId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/payees/{payee-id}"
            .replace("{" + "payee-id" + "}", localVarApiClient.escapeString(payeeId.toString()));

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
    private okhttp3.Call getDetailsValidateBeforeCall(String payeeId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'payeeId' is set
        if (payeeId == null) {
            throw new ApiException("Missing the required parameter 'payeeId' when calling getDetails(Async)");
        }

        return getDetailsCall(payeeId, _callback);

    }


    private ApiResponse<PayeesGetDetailsResponse> getDetailsWithHttpInfo(String payeeId) throws ApiException {
        okhttp3.Call localVarCall = getDetailsValidateBeforeCall(payeeId, null);
        Type localVarReturnType = new TypeToken<PayeesGetDetailsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getDetailsAsync(String payeeId, final ApiCallback<PayeesGetDetailsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getDetailsValidateBeforeCall(payeeId, _callback);
        Type localVarReturnType = new TypeToken<PayeesGetDetailsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetDetailsRequestBuilder {
        private final String payeeId;

        private GetDetailsRequestBuilder(String payeeId) {
            this.payeeId = payeeId;
        }

        /**
         * Build call for getDetails
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getDetailsCall(payeeId, _callback);
        }


        /**
         * Execute getDetails request
         * @return PayeesGetDetailsResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public PayeesGetDetailsResponse execute() throws ApiException {
            ApiResponse<PayeesGetDetailsResponse> localVarResp = getDetailsWithHttpInfo(payeeId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getDetails request with HTTP info returned
         * @return ApiResponse&lt;PayeesGetDetailsResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PayeesGetDetailsResponse> executeWithHttpInfo() throws ApiException {
            return getDetailsWithHttpInfo(payeeId);
        }

        /**
         * Execute getDetails request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PayeesGetDetailsResponse> _callback) throws ApiException {
            return getDetailsAsync(payeeId, _callback);
        }
    }

    /**
     * Get payee
     * Yields payee details
     * @param payeeId  (required)
     * @return GetDetailsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetDetailsRequestBuilder getDetails(String payeeId) throws IllegalArgumentException {
        if (payeeId == null) throw new IllegalArgumentException("\"payeeId\" is required but got null");
            

        return new GetDetailsRequestBuilder(payeeId);
    }
    private okhttp3.Call listLegalPersonPayeesCall(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/legal-persons/{legal-person-id}/bank/payees"
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
    private okhttp3.Call listLegalPersonPayeesValidateBeforeCall(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'legalPersonId' is set
        if (legalPersonId == null) {
            throw new ApiException("Missing the required parameter 'legalPersonId' when calling listLegalPersonPayees(Async)");
        }

        return listLegalPersonPayeesCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);

    }


    private ApiResponse<PayeesListLegalPersonPayeesResponse> listLegalPersonPayeesWithHttpInfo(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore) throws ApiException {
        okhttp3.Call localVarCall = listLegalPersonPayeesValidateBeforeCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, null);
        Type localVarReturnType = new TypeToken<PayeesListLegalPersonPayeesResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listLegalPersonPayeesAsync(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback<PayeesListLegalPersonPayeesResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listLegalPersonPayeesValidateBeforeCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);
        Type localVarReturnType = new TypeToken<PayeesListLegalPersonPayeesResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListLegalPersonPayeesRequestBuilder {
        private final String legalPersonId;
        private String sort;
        private Long pageSize;
        private byte[] pageAfter;
        private byte[] pageBefore;

        private ListLegalPersonPayeesRequestBuilder(String legalPersonId) {
            this.legalPersonId = legalPersonId;
        }

        /**
         * Set sort
         * @param sort  (optional)
         * @return ListLegalPersonPayeesRequestBuilder
         */
        public ListLegalPersonPayeesRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return ListLegalPersonPayeesRequestBuilder
         */
        public ListLegalPersonPayeesRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListLegalPersonPayeesRequestBuilder
         */
        public ListLegalPersonPayeesRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListLegalPersonPayeesRequestBuilder
         */
        public ListLegalPersonPayeesRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Build call for listLegalPersonPayees
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listLegalPersonPayeesCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);
        }


        /**
         * Execute listLegalPersonPayees request
         * @return PayeesListLegalPersonPayeesResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public PayeesListLegalPersonPayeesResponse execute() throws ApiException {
            ApiResponse<PayeesListLegalPersonPayeesResponse> localVarResp = listLegalPersonPayeesWithHttpInfo(legalPersonId, sort, pageSize, pageAfter, pageBefore);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listLegalPersonPayees request with HTTP info returned
         * @return ApiResponse&lt;PayeesListLegalPersonPayeesResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public ApiResponse<PayeesListLegalPersonPayeesResponse> executeWithHttpInfo() throws ApiException {
            return listLegalPersonPayeesWithHttpInfo(legalPersonId, sort, pageSize, pageAfter, pageBefore);
        }

        /**
         * Execute listLegalPersonPayees request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PayeesListLegalPersonPayeesResponse> _callback) throws ApiException {
            return listLegalPersonPayeesAsync(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);
        }
    }

    /**
     * List legal person payees
     * Lists payees belonging to the legal person.
     * @param legalPersonId  (required)
     * @return ListLegalPersonPayeesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
     </table>
     */
    public ListLegalPersonPayeesRequestBuilder listLegalPersonPayees(String legalPersonId) throws IllegalArgumentException {
        if (legalPersonId == null) throw new IllegalArgumentException("\"legalPersonId\" is required but got null");
            

        return new ListLegalPersonPayeesRequestBuilder(legalPersonId);
    }
    private okhttp3.Call registerNewPayeeCall(String legalPersonId, PayeesRegisterNewPayeeRequest payeesRegisterNewPayeeRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = payeesRegisterNewPayeeRequest;

        // create path and map variables
        String localVarPath = "/v0/legal-persons/{legal-person-id}/bank/payees"
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
    private okhttp3.Call registerNewPayeeValidateBeforeCall(String legalPersonId, PayeesRegisterNewPayeeRequest payeesRegisterNewPayeeRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'legalPersonId' is set
        if (legalPersonId == null) {
            throw new ApiException("Missing the required parameter 'legalPersonId' when calling registerNewPayee(Async)");
        }

        // verify the required parameter 'payeesRegisterNewPayeeRequest' is set
        if (payeesRegisterNewPayeeRequest == null) {
            throw new ApiException("Missing the required parameter 'payeesRegisterNewPayeeRequest' when calling registerNewPayee(Async)");
        }

        return registerNewPayeeCall(legalPersonId, payeesRegisterNewPayeeRequest, _callback);

    }


    private ApiResponse<PayeesRegisterNewPayeeResponse> registerNewPayeeWithHttpInfo(String legalPersonId, PayeesRegisterNewPayeeRequest payeesRegisterNewPayeeRequest) throws ApiException {
        okhttp3.Call localVarCall = registerNewPayeeValidateBeforeCall(legalPersonId, payeesRegisterNewPayeeRequest, null);
        Type localVarReturnType = new TypeToken<PayeesRegisterNewPayeeResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call registerNewPayeeAsync(String legalPersonId, PayeesRegisterNewPayeeRequest payeesRegisterNewPayeeRequest, final ApiCallback<PayeesRegisterNewPayeeResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = registerNewPayeeValidateBeforeCall(legalPersonId, payeesRegisterNewPayeeRequest, _callback);
        Type localVarReturnType = new TypeToken<PayeesRegisterNewPayeeResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class RegisterNewPayeeRequestBuilder {
        private final String accountHolder;
        private final String accountNumber;
        private final String bankId;
        private final String legalPersonId;

        private RegisterNewPayeeRequestBuilder(String accountHolder, String accountNumber, String bankId, String legalPersonId) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            this.bankId = bankId;
            this.legalPersonId = legalPersonId;
        }

        /**
         * Build call for registerNewPayee
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            PayeesRegisterNewPayeeRequest payeesRegisterNewPayeeRequest = buildBodyParams();
            return registerNewPayeeCall(legalPersonId, payeesRegisterNewPayeeRequest, _callback);
        }

        private PayeesRegisterNewPayeeRequest buildBodyParams() {
            PayeesRegisterNewPayeeRequest payeesRegisterNewPayeeRequest = new PayeesRegisterNewPayeeRequest();
            payeesRegisterNewPayeeRequest.accountHolder(this.accountHolder);
            payeesRegisterNewPayeeRequest.accountNumber(this.accountNumber);
            payeesRegisterNewPayeeRequest.bankId(this.bankId);
            return payeesRegisterNewPayeeRequest;
        }

        /**
         * Execute registerNewPayee request
         * @return PayeesRegisterNewPayeeResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public PayeesRegisterNewPayeeResponse execute() throws ApiException {
            PayeesRegisterNewPayeeRequest payeesRegisterNewPayeeRequest = buildBodyParams();
            ApiResponse<PayeesRegisterNewPayeeResponse> localVarResp = registerNewPayeeWithHttpInfo(legalPersonId, payeesRegisterNewPayeeRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute registerNewPayee request with HTTP info returned
         * @return ApiResponse&lt;PayeesRegisterNewPayeeResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PayeesRegisterNewPayeeResponse> executeWithHttpInfo() throws ApiException {
            PayeesRegisterNewPayeeRequest payeesRegisterNewPayeeRequest = buildBodyParams();
            return registerNewPayeeWithHttpInfo(legalPersonId, payeesRegisterNewPayeeRequest);
        }

        /**
         * Execute registerNewPayee request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PayeesRegisterNewPayeeResponse> _callback) throws ApiException {
            PayeesRegisterNewPayeeRequest payeesRegisterNewPayeeRequest = buildBodyParams();
            return registerNewPayeeAsync(legalPersonId, payeesRegisterNewPayeeRequest, _callback);
        }
    }

    /**
     * Create payee
     * Registers a new payee for the customer
     * @param legalPersonId  (required)
     * @param payeesRegisterNewPayeeRequest  (required)
     * @return RegisterNewPayeeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public RegisterNewPayeeRequestBuilder registerNewPayee(String accountHolder, String accountNumber, String bankId, String legalPersonId) throws IllegalArgumentException {
        if (accountHolder == null) throw new IllegalArgumentException("\"accountHolder\" is required but got null");
            if (accountHolder != null && accountHolder.length() < 1) {
              throw new IllegalArgumentException("Invalid value for accountHolder. Length must be greater than or equal to 1.");
            }

        if (accountNumber == null) throw new IllegalArgumentException("\"accountNumber\" is required but got null");
            if (accountNumber != null && accountNumber.length() < 8) {
              throw new IllegalArgumentException("Invalid value for accountNumber. Length must be greater than or equal to 8.");
            }

        if (bankId == null) throw new IllegalArgumentException("\"bankId\" is required but got null");
            if (bankId != null && bankId.length() < 6) {
              throw new IllegalArgumentException("Invalid value for bankId. Length must be greater than or equal to 6.");
            }

        if (legalPersonId == null) throw new IllegalArgumentException("\"legalPersonId\" is required but got null");
            

        return new RegisterNewPayeeRequestBuilder(accountHolder, accountNumber, bankId, legalPersonId);
    }
    private okhttp3.Call updatePayeeCall(String payeeId, PayeesUpdatePayeeRequest payeesUpdatePayeeRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = payeesUpdatePayeeRequest;

        // create path and map variables
        String localVarPath = "/v0/payees/{payee-id}"
            .replace("{" + "payee-id" + "}", localVarApiClient.escapeString(payeeId.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updatePayeeValidateBeforeCall(String payeeId, PayeesUpdatePayeeRequest payeesUpdatePayeeRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'payeeId' is set
        if (payeeId == null) {
            throw new ApiException("Missing the required parameter 'payeeId' when calling updatePayee(Async)");
        }

        // verify the required parameter 'payeesUpdatePayeeRequest' is set
        if (payeesUpdatePayeeRequest == null) {
            throw new ApiException("Missing the required parameter 'payeesUpdatePayeeRequest' when calling updatePayee(Async)");
        }

        return updatePayeeCall(payeeId, payeesUpdatePayeeRequest, _callback);

    }


    private ApiResponse<PayeesUpdatePayeeResponse> updatePayeeWithHttpInfo(String payeeId, PayeesUpdatePayeeRequest payeesUpdatePayeeRequest) throws ApiException {
        okhttp3.Call localVarCall = updatePayeeValidateBeforeCall(payeeId, payeesUpdatePayeeRequest, null);
        Type localVarReturnType = new TypeToken<PayeesUpdatePayeeResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updatePayeeAsync(String payeeId, PayeesUpdatePayeeRequest payeesUpdatePayeeRequest, final ApiCallback<PayeesUpdatePayeeResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = updatePayeeValidateBeforeCall(payeeId, payeesUpdatePayeeRequest, _callback);
        Type localVarReturnType = new TypeToken<PayeesUpdatePayeeResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdatePayeeRequestBuilder {
        private final String payeeStatus;
        private final String payeeId;

        private UpdatePayeeRequestBuilder(String payeeStatus, String payeeId) {
            this.payeeStatus = payeeStatus;
            this.payeeId = payeeId;
        }

        /**
         * Build call for updatePayee
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 500 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            PayeesUpdatePayeeRequest payeesUpdatePayeeRequest = buildBodyParams();
            return updatePayeeCall(payeeId, payeesUpdatePayeeRequest, _callback);
        }

        private PayeesUpdatePayeeRequest buildBodyParams() {
            PayeesUpdatePayeeRequest payeesUpdatePayeeRequest = new PayeesUpdatePayeeRequest();
            if (this.payeeStatus != null)
            payeesUpdatePayeeRequest.payeeStatus(PayeesUpdatePayeeRequest.PayeeStatusEnum.fromValue(this.payeeStatus));
            return payeesUpdatePayeeRequest;
        }

        /**
         * Execute updatePayee request
         * @return PayeesUpdatePayeeResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 500 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public PayeesUpdatePayeeResponse execute() throws ApiException {
            PayeesUpdatePayeeRequest payeesUpdatePayeeRequest = buildBodyParams();
            ApiResponse<PayeesUpdatePayeeResponse> localVarResp = updatePayeeWithHttpInfo(payeeId, payeesUpdatePayeeRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updatePayee request with HTTP info returned
         * @return ApiResponse&lt;PayeesUpdatePayeeResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 500 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PayeesUpdatePayeeResponse> executeWithHttpInfo() throws ApiException {
            PayeesUpdatePayeeRequest payeesUpdatePayeeRequest = buildBodyParams();
            return updatePayeeWithHttpInfo(payeeId, payeesUpdatePayeeRequest);
        }

        /**
         * Execute updatePayee request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 500 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PayeesUpdatePayeeResponse> _callback) throws ApiException {
            PayeesUpdatePayeeRequest payeesUpdatePayeeRequest = buildBodyParams();
            return updatePayeeAsync(payeeId, payeesUpdatePayeeRequest, _callback);
        }
    }

    /**
     * Update payee
     * Updates an existing payee.  A payee can be deactivated by updating the &#x60;payee-status&#x60; of an active payee to &#x60;deactivated&#x60;. Any attempt to create or submit a payment to a deactivated payee will fail.  A 422 is served when attempting to deactivate an already-deactivated payee.
     * @param payeeId  (required)
     * @param payeesUpdatePayeeRequest  (required)
     * @return UpdatePayeeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public UpdatePayeeRequestBuilder updatePayee(String payeeStatus, String payeeId) throws IllegalArgumentException {
        if (payeeStatus == null) throw new IllegalArgumentException("\"payeeStatus\" is required but got null");
            

        if (payeeId == null) throw new IllegalArgumentException("\"payeeId\" is required but got null");
            

        return new UpdatePayeeRequestBuilder(payeeStatus, payeeId);
    }
}
