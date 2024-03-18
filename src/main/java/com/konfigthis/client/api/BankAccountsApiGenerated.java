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


import com.konfigthis.client.model.BankAccountsCloseAccountResponse;
import com.konfigthis.client.model.BankAccountsCreateNewAccountRequest;
import com.konfigthis.client.model.BankAccountsCreateNewAccountResponse;
import com.konfigthis.client.model.BankAccountsGetAccountResponse;
import com.konfigthis.client.model.BankAccountsListResponse;
import com.konfigthis.client.model.BankAccountsUpdateBankAccountRequest;
import com.konfigthis.client.model.BankAccountsUpdateBankAccountResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class BankAccountsApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public BankAccountsApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public BankAccountsApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call closeAccountCall(String bankAccountId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/bank/accounts/{bank-account-id}/actions/close"
            .replace("{" + "bank-account-id" + "}", localVarApiClient.escapeString(bankAccountId.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call closeAccountValidateBeforeCall(String bankAccountId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'bankAccountId' is set
        if (bankAccountId == null) {
            throw new ApiException("Missing the required parameter 'bankAccountId' when calling closeAccount(Async)");
        }

        return closeAccountCall(bankAccountId, _callback);

    }


    private ApiResponse<BankAccountsCloseAccountResponse> closeAccountWithHttpInfo(String bankAccountId) throws ApiException {
        okhttp3.Call localVarCall = closeAccountValidateBeforeCall(bankAccountId, null);
        Type localVarReturnType = new TypeToken<BankAccountsCloseAccountResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call closeAccountAsync(String bankAccountId, final ApiCallback<BankAccountsCloseAccountResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = closeAccountValidateBeforeCall(bankAccountId, _callback);
        Type localVarReturnType = new TypeToken<BankAccountsCloseAccountResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CloseAccountRequestBuilder {
        private final String bankAccountId;

        private CloseAccountRequestBuilder(String bankAccountId) {
            this.bankAccountId = bankAccountId;
        }

        /**
         * Build call for closeAccount
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> An error occurred when trying to close the bank account. See [https://docs.griffin.com/docs/errors/account-close](https://docs.griffin.com/docs/errors/account-close) for details. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return closeAccountCall(bankAccountId, _callback);
        }


        /**
         * Execute closeAccount request
         * @return BankAccountsCloseAccountResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> An error occurred when trying to close the bank account. See [https://docs.griffin.com/docs/errors/account-close](https://docs.griffin.com/docs/errors/account-close) for details. </td><td>  -  </td></tr>
         </table>
         */
        public BankAccountsCloseAccountResponse execute() throws ApiException {
            ApiResponse<BankAccountsCloseAccountResponse> localVarResp = closeAccountWithHttpInfo(bankAccountId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute closeAccount request with HTTP info returned
         * @return ApiResponse&lt;BankAccountsCloseAccountResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> An error occurred when trying to close the bank account. See [https://docs.griffin.com/docs/errors/account-close](https://docs.griffin.com/docs/errors/account-close) for details. </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<BankAccountsCloseAccountResponse> executeWithHttpInfo() throws ApiException {
            return closeAccountWithHttpInfo(bankAccountId);
        }

        /**
         * Execute closeAccount request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> An error occurred when trying to close the bank account. See [https://docs.griffin.com/docs/errors/account-close](https://docs.griffin.com/docs/errors/account-close) for details. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<BankAccountsCloseAccountResponse> _callback) throws ApiException {
            return closeAccountAsync(bankAccountId, _callback);
        }
    }

    /**
     * 
     * Close a bank account
     * @param bankAccountId  (required)
     * @return CloseAccountRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> An error occurred when trying to close the bank account. See [https://docs.griffin.com/docs/errors/account-close](https://docs.griffin.com/docs/errors/account-close) for details. </td><td>  -  </td></tr>
     </table>
     */
    public CloseAccountRequestBuilder closeAccount(String bankAccountId) throws IllegalArgumentException {
        if (bankAccountId == null) throw new IllegalArgumentException("\"bankAccountId\" is required but got null");
            

        return new CloseAccountRequestBuilder(bankAccountId);
    }
    private okhttp3.Call createNewAccountCall(String organizationId, BankAccountsCreateNewAccountRequest bankAccountsCreateNewAccountRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = bankAccountsCreateNewAccountRequest;

        // create path and map variables
        String localVarPath = "/v0/organizations/{organization-id}/bank/accounts"
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
    private okhttp3.Call createNewAccountValidateBeforeCall(String organizationId, BankAccountsCreateNewAccountRequest bankAccountsCreateNewAccountRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling createNewAccount(Async)");
        }

        // verify the required parameter 'bankAccountsCreateNewAccountRequest' is set
        if (bankAccountsCreateNewAccountRequest == null) {
            throw new ApiException("Missing the required parameter 'bankAccountsCreateNewAccountRequest' when calling createNewAccount(Async)");
        }

        return createNewAccountCall(organizationId, bankAccountsCreateNewAccountRequest, _callback);

    }


    private ApiResponse<BankAccountsCreateNewAccountResponse> createNewAccountWithHttpInfo(String organizationId, BankAccountsCreateNewAccountRequest bankAccountsCreateNewAccountRequest) throws ApiException {
        okhttp3.Call localVarCall = createNewAccountValidateBeforeCall(organizationId, bankAccountsCreateNewAccountRequest, null);
        Type localVarReturnType = new TypeToken<BankAccountsCreateNewAccountResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewAccountAsync(String organizationId, BankAccountsCreateNewAccountRequest bankAccountsCreateNewAccountRequest, final ApiCallback<BankAccountsCreateNewAccountResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewAccountValidateBeforeCall(organizationId, bankAccountsCreateNewAccountRequest, _callback);
        Type localVarReturnType = new TypeToken<BankAccountsCreateNewAccountResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewAccountRequestBuilder {
        private final String bankProductType;
        private final String organizationId;
        private String ownerUrl;
        private String savingsType;
        private String displayName;

        private CreateNewAccountRequestBuilder(String bankProductType, String organizationId) {
            this.bankProductType = bankProductType;
            this.organizationId = organizationId;
        }

        /**
         * Set ownerUrl
         * @param ownerUrl Link to the [legal person](http://docs.griffin.com) that represents the [owner](http://docs.griffin.com) of the account. (optional)
         * @return CreateNewAccountRequestBuilder
         */
        public CreateNewAccountRequestBuilder ownerUrl(String ownerUrl) {
            this.ownerUrl = ownerUrl;
            return this;
        }
        
        /**
         * Set savingsType
         * @param savingsType Specifies the type of savings account. (optional)
         * @return CreateNewAccountRequestBuilder
         */
        public CreateNewAccountRequestBuilder savingsType(String savingsType) {
            this.savingsType = savingsType;
            return this;
        }
        
        /**
         * Set displayName
         * @param displayName A human readable label for an entity (optional)
         * @return CreateNewAccountRequestBuilder
         */
        public CreateNewAccountRequestBuilder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }
        
        /**
         * Build call for createNewAccount
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
            BankAccountsCreateNewAccountRequest bankAccountsCreateNewAccountRequest = buildBodyParams();
            return createNewAccountCall(organizationId, bankAccountsCreateNewAccountRequest, _callback);
        }

        private BankAccountsCreateNewAccountRequest buildBodyParams() {
            BankAccountsCreateNewAccountRequest bankAccountsCreateNewAccountRequest = new BankAccountsCreateNewAccountRequest();
            bankAccountsCreateNewAccountRequest.ownerUrl(this.ownerUrl);
            if (this.savingsType != null)
            bankAccountsCreateNewAccountRequest.savingsType(BankAccountsCreateNewAccountRequest.SavingsTypeEnum.fromValue(this.savingsType));
            bankAccountsCreateNewAccountRequest.displayName(this.displayName);
            if (this.bankProductType != null)
            bankAccountsCreateNewAccountRequest.bankProductType(BankAccountsCreateNewAccountRequest.BankProductTypeEnum.fromValue(this.bankProductType));
            return bankAccountsCreateNewAccountRequest;
        }

        /**
         * Execute createNewAccount request
         * @return BankAccountsCreateNewAccountResponse
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
        public BankAccountsCreateNewAccountResponse execute() throws ApiException {
            BankAccountsCreateNewAccountRequest bankAccountsCreateNewAccountRequest = buildBodyParams();
            ApiResponse<BankAccountsCreateNewAccountResponse> localVarResp = createNewAccountWithHttpInfo(organizationId, bankAccountsCreateNewAccountRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNewAccount request with HTTP info returned
         * @return ApiResponse&lt;BankAccountsCreateNewAccountResponse&gt;
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
        public ApiResponse<BankAccountsCreateNewAccountResponse> executeWithHttpInfo() throws ApiException {
            BankAccountsCreateNewAccountRequest bankAccountsCreateNewAccountRequest = buildBodyParams();
            return createNewAccountWithHttpInfo(organizationId, bankAccountsCreateNewAccountRequest);
        }

        /**
         * Execute createNewAccount request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<BankAccountsCreateNewAccountResponse> _callback) throws ApiException {
            BankAccountsCreateNewAccountRequest bankAccountsCreateNewAccountRequest = buildBodyParams();
            return createNewAccountAsync(organizationId, bankAccountsCreateNewAccountRequest, _callback);
        }
    }

    /**
     * Open bank account
     * Open a new bank account
     * @param organizationId  (required)
     * @param bankAccountsCreateNewAccountRequest  (required)
     * @return CreateNewAccountRequestBuilder
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
    public CreateNewAccountRequestBuilder createNewAccount(String bankProductType, String organizationId) throws IllegalArgumentException {
        if (bankProductType == null) throw new IllegalArgumentException("\"bankProductType\" is required but got null");
            

        if (organizationId == null) throw new IllegalArgumentException("\"organizationId\" is required but got null");
            

        return new CreateNewAccountRequestBuilder(bankProductType, organizationId);
    }
    private okhttp3.Call getAccountCall(String bankAccountId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/bank/accounts/{bank-account-id}"
            .replace("{" + "bank-account-id" + "}", localVarApiClient.escapeString(bankAccountId.toString()));

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
    private okhttp3.Call getAccountValidateBeforeCall(String bankAccountId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'bankAccountId' is set
        if (bankAccountId == null) {
            throw new ApiException("Missing the required parameter 'bankAccountId' when calling getAccount(Async)");
        }

        return getAccountCall(bankAccountId, _callback);

    }


    private ApiResponse<BankAccountsGetAccountResponse> getAccountWithHttpInfo(String bankAccountId) throws ApiException {
        okhttp3.Call localVarCall = getAccountValidateBeforeCall(bankAccountId, null);
        Type localVarReturnType = new TypeToken<BankAccountsGetAccountResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getAccountAsync(String bankAccountId, final ApiCallback<BankAccountsGetAccountResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAccountValidateBeforeCall(bankAccountId, _callback);
        Type localVarReturnType = new TypeToken<BankAccountsGetAccountResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetAccountRequestBuilder {
        private final String bankAccountId;

        private GetAccountRequestBuilder(String bankAccountId) {
            this.bankAccountId = bankAccountId;
        }

        /**
         * Build call for getAccount
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getAccountCall(bankAccountId, _callback);
        }


        /**
         * Execute getAccount request
         * @return BankAccountsGetAccountResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public BankAccountsGetAccountResponse execute() throws ApiException {
            ApiResponse<BankAccountsGetAccountResponse> localVarResp = getAccountWithHttpInfo(bankAccountId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getAccount request with HTTP info returned
         * @return ApiResponse&lt;BankAccountsGetAccountResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<BankAccountsGetAccountResponse> executeWithHttpInfo() throws ApiException {
            return getAccountWithHttpInfo(bankAccountId);
        }

        /**
         * Execute getAccount request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<BankAccountsGetAccountResponse> _callback) throws ApiException {
            return getAccountAsync(bankAccountId, _callback);
        }
    }

    /**
     * Get bank account
     * Fetch a bank account
     * @param bankAccountId  (required)
     * @return GetAccountRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetAccountRequestBuilder getAccount(String bankAccountId) throws IllegalArgumentException {
        if (bankAccountId == null) throw new IllegalArgumentException("\"bankAccountId\" is required but got null");
            

        return new GetAccountRequestBuilder(bankAccountId);
    }
    private okhttp3.Call listCall(String organizationId, String filterBeneficiaryEq, String filterOwnerEq, Long pageSize, List<String> include, List<String> filterAccountStatusIn, String sort, byte[] pageAfter, Boolean filterAccountRestrictedIn, Boolean filterPooledFundsEq, List<String> filterBankProductTypeIn, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/organizations/{organization-id}/bank/accounts"
            .replace("{" + "organization-id" + "}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (filterBeneficiaryEq != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[beneficiary][eq]", filterBeneficiaryEq));
        }

        if (filterOwnerEq != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[owner][eq]", filterOwnerEq));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[size]", pageSize));
        }

        if (include != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("csv", "include", include));
        }

        if (filterAccountStatusIn != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("csv", "filter[account-status][in][]", filterAccountStatusIn));
        }

        if (sort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort", sort));
        }

        if (pageAfter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[after]", pageAfter));
        }

        if (filterAccountRestrictedIn != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[account-restricted][in][]", filterAccountRestrictedIn));
        }

        if (filterPooledFundsEq != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[pooled-funds][eq]", filterPooledFundsEq));
        }

        if (filterBankProductTypeIn != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("csv", "filter[bank-product-type][in][]", filterBankProductTypeIn));
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
    private okhttp3.Call listValidateBeforeCall(String organizationId, String filterBeneficiaryEq, String filterOwnerEq, Long pageSize, List<String> include, List<String> filterAccountStatusIn, String sort, byte[] pageAfter, Boolean filterAccountRestrictedIn, Boolean filterPooledFundsEq, List<String> filterBankProductTypeIn, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling list(Async)");
        }

        return listCall(organizationId, filterBeneficiaryEq, filterOwnerEq, pageSize, include, filterAccountStatusIn, sort, pageAfter, filterAccountRestrictedIn, filterPooledFundsEq, filterBankProductTypeIn, pageBefore, _callback);

    }


    private ApiResponse<BankAccountsListResponse> listWithHttpInfo(String organizationId, String filterBeneficiaryEq, String filterOwnerEq, Long pageSize, List<String> include, List<String> filterAccountStatusIn, String sort, byte[] pageAfter, Boolean filterAccountRestrictedIn, Boolean filterPooledFundsEq, List<String> filterBankProductTypeIn, byte[] pageBefore) throws ApiException {
        okhttp3.Call localVarCall = listValidateBeforeCall(organizationId, filterBeneficiaryEq, filterOwnerEq, pageSize, include, filterAccountStatusIn, sort, pageAfter, filterAccountRestrictedIn, filterPooledFundsEq, filterBankProductTypeIn, pageBefore, null);
        Type localVarReturnType = new TypeToken<BankAccountsListResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listAsync(String organizationId, String filterBeneficiaryEq, String filterOwnerEq, Long pageSize, List<String> include, List<String> filterAccountStatusIn, String sort, byte[] pageAfter, Boolean filterAccountRestrictedIn, Boolean filterPooledFundsEq, List<String> filterBankProductTypeIn, byte[] pageBefore, final ApiCallback<BankAccountsListResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listValidateBeforeCall(organizationId, filterBeneficiaryEq, filterOwnerEq, pageSize, include, filterAccountStatusIn, sort, pageAfter, filterAccountRestrictedIn, filterPooledFundsEq, filterBankProductTypeIn, pageBefore, _callback);
        Type localVarReturnType = new TypeToken<BankAccountsListResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListRequestBuilder {
        private final String organizationId;
        private String filterBeneficiaryEq;
        private String filterOwnerEq;
        private Long pageSize;
        private List<String> include;
        private List<String> filterAccountStatusIn;
        private String sort;
        private byte[] pageAfter;
        private Boolean filterAccountRestrictedIn;
        private Boolean filterPooledFundsEq;
        private List<String> filterBankProductTypeIn;
        private byte[] pageBefore;

        private ListRequestBuilder(String organizationId) {
            this.organizationId = organizationId;
        }

        /**
         * Set filterBeneficiaryEq
         * @param filterBeneficiaryEq Link to the [legal person](http://docs.griffin.com) that represents the [beneficiary](http://docs.griffin.com) of the account. (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder filterBeneficiaryEq(String filterBeneficiaryEq) {
            this.filterBeneficiaryEq = filterBeneficiaryEq;
            return this;
        }
        
        /**
         * Set filterOwnerEq
         * @param filterOwnerEq Link to the [legal person](http://docs.griffin.com) that represents the [owner](http://docs.griffin.com) of the account. (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder filterOwnerEq(String filterOwnerEq) {
            this.filterOwnerEq = filterOwnerEq;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set include
         * @param include For each bank account returned, include its owner and/or beneficiary in the response under the &#x60;included.legal-persons&#x60; attribute. (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder include(List<String> include) {
            this.include = include;
            return this;
        }
        
        /**
         * Set filterAccountStatusIn
         * @param filterAccountStatusIn  (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder filterAccountStatusIn(List<String> filterAccountStatusIn) {
            this.filterAccountStatusIn = filterAccountStatusIn;
            return this;
        }
        
        /**
         * Set sort
         * @param sort  (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set filterAccountRestrictedIn
         * @param filterAccountRestrictedIn Specifies whether the bank account has restrictions applied by Griffin. (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder filterAccountRestrictedIn(Boolean filterAccountRestrictedIn) {
            this.filterAccountRestrictedIn = filterAccountRestrictedIn;
            return this;
        }
        
        /**
         * Set filterPooledFundsEq
         * @param filterPooledFundsEq Specifies whether the bank account holds funds belonging to multiple beneficiaries. (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder filterPooledFundsEq(Boolean filterPooledFundsEq) {
            this.filterPooledFundsEq = filterPooledFundsEq;
            return this;
        }
        
        /**
         * Set filterBankProductTypeIn
         * @param filterBankProductTypeIn  (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder filterBankProductTypeIn(List<String> filterBankProductTypeIn) {
            this.filterBankProductTypeIn = filterBankProductTypeIn;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListRequestBuilder
         */
        public ListRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Build call for list
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
            return listCall(organizationId, filterBeneficiaryEq, filterOwnerEq, pageSize, include, filterAccountStatusIn, sort, pageAfter, filterAccountRestrictedIn, filterPooledFundsEq, filterBankProductTypeIn, pageBefore, _callback);
        }


        /**
         * Execute list request
         * @return BankAccountsListResponse
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
        public BankAccountsListResponse execute() throws ApiException {
            ApiResponse<BankAccountsListResponse> localVarResp = listWithHttpInfo(organizationId, filterBeneficiaryEq, filterOwnerEq, pageSize, include, filterAccountStatusIn, sort, pageAfter, filterAccountRestrictedIn, filterPooledFundsEq, filterBankProductTypeIn, pageBefore);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute list request with HTTP info returned
         * @return ApiResponse&lt;BankAccountsListResponse&gt;
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
        public ApiResponse<BankAccountsListResponse> executeWithHttpInfo() throws ApiException {
            return listWithHttpInfo(organizationId, filterBeneficiaryEq, filterOwnerEq, pageSize, include, filterAccountStatusIn, sort, pageAfter, filterAccountRestrictedIn, filterPooledFundsEq, filterBankProductTypeIn, pageBefore);
        }

        /**
         * Execute list request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<BankAccountsListResponse> _callback) throws ApiException {
            return listAsync(organizationId, filterBeneficiaryEq, filterOwnerEq, pageSize, include, filterAccountStatusIn, sort, pageAfter, filterAccountRestrictedIn, filterPooledFundsEq, filterBankProductTypeIn, pageBefore, _callback);
        }
    }

    /**
     * List bank accounts
     * Yields a list of all bank accounts under the control of this Organization.
     * @param organizationId  (required)
     * @return ListRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ListRequestBuilder list(String organizationId) throws IllegalArgumentException {
        if (organizationId == null) throw new IllegalArgumentException("\"organizationId\" is required but got null");
            

        return new ListRequestBuilder(organizationId);
    }
    private okhttp3.Call updateBankAccountCall(String bankAccountId, BankAccountsUpdateBankAccountRequest bankAccountsUpdateBankAccountRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = bankAccountsUpdateBankAccountRequest;

        // create path and map variables
        String localVarPath = "/v0/bank/accounts/{bank-account-id}"
            .replace("{" + "bank-account-id" + "}", localVarApiClient.escapeString(bankAccountId.toString()));

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
    private okhttp3.Call updateBankAccountValidateBeforeCall(String bankAccountId, BankAccountsUpdateBankAccountRequest bankAccountsUpdateBankAccountRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'bankAccountId' is set
        if (bankAccountId == null) {
            throw new ApiException("Missing the required parameter 'bankAccountId' when calling updateBankAccount(Async)");
        }

        // verify the required parameter 'bankAccountsUpdateBankAccountRequest' is set
        if (bankAccountsUpdateBankAccountRequest == null) {
            throw new ApiException("Missing the required parameter 'bankAccountsUpdateBankAccountRequest' when calling updateBankAccount(Async)");
        }

        return updateBankAccountCall(bankAccountId, bankAccountsUpdateBankAccountRequest, _callback);

    }


    private ApiResponse<BankAccountsUpdateBankAccountResponse> updateBankAccountWithHttpInfo(String bankAccountId, BankAccountsUpdateBankAccountRequest bankAccountsUpdateBankAccountRequest) throws ApiException {
        okhttp3.Call localVarCall = updateBankAccountValidateBeforeCall(bankAccountId, bankAccountsUpdateBankAccountRequest, null);
        Type localVarReturnType = new TypeToken<BankAccountsUpdateBankAccountResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateBankAccountAsync(String bankAccountId, BankAccountsUpdateBankAccountRequest bankAccountsUpdateBankAccountRequest, final ApiCallback<BankAccountsUpdateBankAccountResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateBankAccountValidateBeforeCall(bankAccountId, bankAccountsUpdateBankAccountRequest, _callback);
        Type localVarReturnType = new TypeToken<BankAccountsUpdateBankAccountResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateBankAccountRequestBuilder {
        private final String displayName;
        private final String bankAccountId;

        private UpdateBankAccountRequestBuilder(String displayName, String bankAccountId) {
            this.displayName = displayName;
            this.bankAccountId = bankAccountId;
        }

        /**
         * Build call for updateBankAccount
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
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            BankAccountsUpdateBankAccountRequest bankAccountsUpdateBankAccountRequest = buildBodyParams();
            return updateBankAccountCall(bankAccountId, bankAccountsUpdateBankAccountRequest, _callback);
        }

        private BankAccountsUpdateBankAccountRequest buildBodyParams() {
            BankAccountsUpdateBankAccountRequest bankAccountsUpdateBankAccountRequest = new BankAccountsUpdateBankAccountRequest();
            bankAccountsUpdateBankAccountRequest.displayName(this.displayName);
            return bankAccountsUpdateBankAccountRequest;
        }

        /**
         * Execute updateBankAccount request
         * @return BankAccountsUpdateBankAccountResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public BankAccountsUpdateBankAccountResponse execute() throws ApiException {
            BankAccountsUpdateBankAccountRequest bankAccountsUpdateBankAccountRequest = buildBodyParams();
            ApiResponse<BankAccountsUpdateBankAccountResponse> localVarResp = updateBankAccountWithHttpInfo(bankAccountId, bankAccountsUpdateBankAccountRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateBankAccount request with HTTP info returned
         * @return ApiResponse&lt;BankAccountsUpdateBankAccountResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<BankAccountsUpdateBankAccountResponse> executeWithHttpInfo() throws ApiException {
            BankAccountsUpdateBankAccountRequest bankAccountsUpdateBankAccountRequest = buildBodyParams();
            return updateBankAccountWithHttpInfo(bankAccountId, bankAccountsUpdateBankAccountRequest);
        }

        /**
         * Execute updateBankAccount request (asynchronously)
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
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<BankAccountsUpdateBankAccountResponse> _callback) throws ApiException {
            BankAccountsUpdateBankAccountRequest bankAccountsUpdateBankAccountRequest = buildBodyParams();
            return updateBankAccountAsync(bankAccountId, bankAccountsUpdateBankAccountRequest, _callback);
        }
    }

    /**
     * 
     * Update a bank account
     * @param bankAccountId  (required)
     * @param bankAccountsUpdateBankAccountRequest  (required)
     * @return UpdateBankAccountRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
        <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public UpdateBankAccountRequestBuilder updateBankAccount(String displayName, String bankAccountId) throws IllegalArgumentException {
        if (displayName == null) throw new IllegalArgumentException("\"displayName\" is required but got null");
            if (displayName != null && displayName.length() < 1) {
              throw new IllegalArgumentException("Invalid value for displayName. Length must be greater than or equal to 1.");
            }

        if (bankAccountId == null) throw new IllegalArgumentException("\"bankAccountId\" is required but got null");
            

        return new UpdateBankAccountRequestBuilder(displayName, bankAccountId);
    }
}
