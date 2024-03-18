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


import java.time.OffsetDateTime;
import com.konfigthis.client.model.PayeeProperty;
import com.konfigthis.client.model.PaymentAmountProperty;
import com.konfigthis.client.model.PaymentsCreateRequestRequest;
import com.konfigthis.client.model.PaymentsCreateRequestResponse;
import com.konfigthis.client.model.PaymentsGetAdmissionResponse;
import com.konfigthis.client.model.PaymentsGetBankAccountPaymentsResponse;
import com.konfigthis.client.model.PaymentsGetDetailsResponse;
import com.konfigthis.client.model.PaymentsGetSubmissionResponse;
import com.konfigthis.client.model.PaymentsListAdmissionsResponse;
import com.konfigthis.client.model.PaymentsListBankAccountAdmissionsResponse;
import com.konfigthis.client.model.PaymentsListSubmissions200Response;
import com.konfigthis.client.model.PaymentsListSubmissionsResponse;
import com.konfigthis.client.model.PaymentsSubmitPaymentSubmissionRequest;
import com.konfigthis.client.model.PaymentsSubmitPaymentSubmissionResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class PaymentsApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PaymentsApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public PaymentsApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createRequestCall(String bankAccountId, PaymentsCreateRequestRequest paymentsCreateRequestRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = paymentsCreateRequestRequest;

        // create path and map variables
        String localVarPath = "/v0/bank/accounts/{bank-account-id}/payments"
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
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createRequestValidateBeforeCall(String bankAccountId, PaymentsCreateRequestRequest paymentsCreateRequestRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'bankAccountId' is set
        if (bankAccountId == null) {
            throw new ApiException("Missing the required parameter 'bankAccountId' when calling createRequest(Async)");
        }

        // verify the required parameter 'paymentsCreateRequestRequest' is set
        if (paymentsCreateRequestRequest == null) {
            throw new ApiException("Missing the required parameter 'paymentsCreateRequestRequest' when calling createRequest(Async)");
        }

        return createRequestCall(bankAccountId, paymentsCreateRequestRequest, _callback);

    }


    private ApiResponse<PaymentsCreateRequestResponse> createRequestWithHttpInfo(String bankAccountId, PaymentsCreateRequestRequest paymentsCreateRequestRequest) throws ApiException {
        okhttp3.Call localVarCall = createRequestValidateBeforeCall(bankAccountId, paymentsCreateRequestRequest, null);
        Type localVarReturnType = new TypeToken<PaymentsCreateRequestResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createRequestAsync(String bankAccountId, PaymentsCreateRequestRequest paymentsCreateRequestRequest, final ApiCallback<PaymentsCreateRequestResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = createRequestValidateBeforeCall(bankAccountId, paymentsCreateRequestRequest, _callback);
        Type localVarReturnType = new TypeToken<PaymentsCreateRequestResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateRequestRequestBuilder {
        private final PayeeProperty creditor;
        private final PaymentAmountProperty paymentAmount;
        private final String bankAccountId;
        private String paymentReference;

        private CreateRequestRequestBuilder(PayeeProperty creditor, PaymentAmountProperty paymentAmount, String bankAccountId) {
            this.creditor = creditor;
            this.paymentAmount = paymentAmount;
            this.bankAccountId = bankAccountId;
        }

        /**
         * Set paymentReference
         * @param paymentReference Free-text field to help identify and categorise payments. (optional)
         * @return CreateRequestRequestBuilder
         */
        public CreateRequestRequestBuilder paymentReference(String paymentReference) {
            this.paymentReference = paymentReference;
            return this;
        }
        
        /**
         * Build call for createRequest
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
            <tr><td> 422 </td><td> An error occurred when trying to create the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            PaymentsCreateRequestRequest paymentsCreateRequestRequest = buildBodyParams();
            return createRequestCall(bankAccountId, paymentsCreateRequestRequest, _callback);
        }

        private PaymentsCreateRequestRequest buildBodyParams() {
            PaymentsCreateRequestRequest paymentsCreateRequestRequest = new PaymentsCreateRequestRequest();
            paymentsCreateRequestRequest.creditor(this.creditor);
            paymentsCreateRequestRequest.paymentAmount(this.paymentAmount);
            paymentsCreateRequestRequest.paymentReference(this.paymentReference);
            return paymentsCreateRequestRequest;
        }

        /**
         * Execute createRequest request
         * @return PaymentsCreateRequestResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> An error occurred when trying to create the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public PaymentsCreateRequestResponse execute() throws ApiException {
            PaymentsCreateRequestRequest paymentsCreateRequestRequest = buildBodyParams();
            ApiResponse<PaymentsCreateRequestResponse> localVarResp = createRequestWithHttpInfo(bankAccountId, paymentsCreateRequestRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createRequest request with HTTP info returned
         * @return ApiResponse&lt;PaymentsCreateRequestResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> An error occurred when trying to create the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PaymentsCreateRequestResponse> executeWithHttpInfo() throws ApiException {
            PaymentsCreateRequestRequest paymentsCreateRequestRequest = buildBodyParams();
            return createRequestWithHttpInfo(bankAccountId, paymentsCreateRequestRequest);
        }

        /**
         * Execute createRequest request (asynchronously)
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
            <tr><td> 422 </td><td> An error occurred when trying to create the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PaymentsCreateRequestResponse> _callback) throws ApiException {
            PaymentsCreateRequestRequest paymentsCreateRequestRequest = buildBodyParams();
            return createRequestAsync(bankAccountId, paymentsCreateRequestRequest, _callback);
        }
    }

    /**
     * Create payment
     * Registers a new payment request for the bank account
     * @param bankAccountId  (required)
     * @param paymentsCreateRequestRequest  (required)
     * @return CreateRequestRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> An error occurred when trying to create the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public CreateRequestRequestBuilder createRequest(PayeeProperty creditor, PaymentAmountProperty paymentAmount, String bankAccountId) throws IllegalArgumentException {
        if (creditor == null) throw new IllegalArgumentException("\"creditor\" is required but got null");
        if (paymentAmount == null) throw new IllegalArgumentException("\"paymentAmount\" is required but got null");
        if (bankAccountId == null) throw new IllegalArgumentException("\"bankAccountId\" is required but got null");
            

        return new CreateRequestRequestBuilder(creditor, paymentAmount, bankAccountId);
    }
    private okhttp3.Call getAdmissionCall(String admissionId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/admissions/{admission-id}"
            .replace("{" + "admission-id" + "}", localVarApiClient.escapeString(admissionId.toString()));

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
    private okhttp3.Call getAdmissionValidateBeforeCall(String admissionId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'admissionId' is set
        if (admissionId == null) {
            throw new ApiException("Missing the required parameter 'admissionId' when calling getAdmission(Async)");
        }

        return getAdmissionCall(admissionId, _callback);

    }


    private ApiResponse<PaymentsGetAdmissionResponse> getAdmissionWithHttpInfo(String admissionId) throws ApiException {
        okhttp3.Call localVarCall = getAdmissionValidateBeforeCall(admissionId, null);
        Type localVarReturnType = new TypeToken<PaymentsGetAdmissionResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getAdmissionAsync(String admissionId, final ApiCallback<PaymentsGetAdmissionResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAdmissionValidateBeforeCall(admissionId, _callback);
        Type localVarReturnType = new TypeToken<PaymentsGetAdmissionResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetAdmissionRequestBuilder {
        private final String admissionId;

        private GetAdmissionRequestBuilder(String admissionId) {
            this.admissionId = admissionId;
        }

        /**
         * Build call for getAdmission
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getAdmissionCall(admissionId, _callback);
        }


        /**
         * Execute getAdmission request
         * @return PaymentsGetAdmissionResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public PaymentsGetAdmissionResponse execute() throws ApiException {
            ApiResponse<PaymentsGetAdmissionResponse> localVarResp = getAdmissionWithHttpInfo(admissionId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getAdmission request with HTTP info returned
         * @return ApiResponse&lt;PaymentsGetAdmissionResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PaymentsGetAdmissionResponse> executeWithHttpInfo() throws ApiException {
            return getAdmissionWithHttpInfo(admissionId);
        }

        /**
         * Execute getAdmission request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PaymentsGetAdmissionResponse> _callback) throws ApiException {
            return getAdmissionAsync(admissionId, _callback);
        }
    }

    /**
     * Get payment admission
     * Yields an admission.
     * @param admissionId  (required)
     * @return GetAdmissionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetAdmissionRequestBuilder getAdmission(String admissionId) throws IllegalArgumentException {
        if (admissionId == null) throw new IllegalArgumentException("\"admissionId\" is required but got null");
            

        return new GetAdmissionRequestBuilder(admissionId);
    }
    private okhttp3.Call getBankAccountPaymentsCall(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/bank/accounts/{bank-account-id}/payments"
            .replace("{" + "bank-account-id" + "}", localVarApiClient.escapeString(bankAccountId.toString()));

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

        if (pageBefore != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[before]", pageBefore));
        }

        if (pageAfter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[after]", pageAfter));
        }

        if (filterCreatedAtLte != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][lte]", filterCreatedAtLte));
        }

        if (filterCreatedAtLt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][lt]", filterCreatedAtLt));
        }

        if (filterCreatedAtGte != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][gte]", filterCreatedAtGte));
        }

        if (filterCreatedAtGt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][gt]", filterCreatedAtGt));
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
    private okhttp3.Call getBankAccountPaymentsValidateBeforeCall(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'bankAccountId' is set
        if (bankAccountId == null) {
            throw new ApiException("Missing the required parameter 'bankAccountId' when calling getBankAccountPayments(Async)");
        }

        return getBankAccountPaymentsCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, _callback);

    }


    private ApiResponse<PaymentsGetBankAccountPaymentsResponse> getBankAccountPaymentsWithHttpInfo(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt) throws ApiException {
        okhttp3.Call localVarCall = getBankAccountPaymentsValidateBeforeCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, null);
        Type localVarReturnType = new TypeToken<PaymentsGetBankAccountPaymentsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getBankAccountPaymentsAsync(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt, final ApiCallback<PaymentsGetBankAccountPaymentsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBankAccountPaymentsValidateBeforeCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, _callback);
        Type localVarReturnType = new TypeToken<PaymentsGetBankAccountPaymentsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetBankAccountPaymentsRequestBuilder {
        private final String bankAccountId;
        private String sort;
        private Long pageSize;
        private byte[] pageBefore;
        private byte[] pageAfter;
        private OffsetDateTime filterCreatedAtLte;
        private OffsetDateTime filterCreatedAtLt;
        private OffsetDateTime filterCreatedAtGte;
        private OffsetDateTime filterCreatedAtGt;

        private GetBankAccountPaymentsRequestBuilder(String bankAccountId) {
            this.bankAccountId = bankAccountId;
        }

        /**
         * Set sort
         * @param sort  (optional)
         * @return GetBankAccountPaymentsRequestBuilder
         */
        public GetBankAccountPaymentsRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return GetBankAccountPaymentsRequestBuilder
         */
        public GetBankAccountPaymentsRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return GetBankAccountPaymentsRequestBuilder
         */
        public GetBankAccountPaymentsRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return GetBankAccountPaymentsRequestBuilder
         */
        public GetBankAccountPaymentsRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set filterCreatedAtLte
         * @param filterCreatedAtLte Return only resources with a created-at less than or equal to the given timestamp. (optional)
         * @return GetBankAccountPaymentsRequestBuilder
         */
        public GetBankAccountPaymentsRequestBuilder filterCreatedAtLte(OffsetDateTime filterCreatedAtLte) {
            this.filterCreatedAtLte = filterCreatedAtLte;
            return this;
        }
        
        /**
         * Set filterCreatedAtLt
         * @param filterCreatedAtLt Return only resources with a created-at less than the given timestamp. (optional)
         * @return GetBankAccountPaymentsRequestBuilder
         */
        public GetBankAccountPaymentsRequestBuilder filterCreatedAtLt(OffsetDateTime filterCreatedAtLt) {
            this.filterCreatedAtLt = filterCreatedAtLt;
            return this;
        }
        
        /**
         * Set filterCreatedAtGte
         * @param filterCreatedAtGte Return only resources with a created-at greater than or equal to the given timestamp. (optional)
         * @return GetBankAccountPaymentsRequestBuilder
         */
        public GetBankAccountPaymentsRequestBuilder filterCreatedAtGte(OffsetDateTime filterCreatedAtGte) {
            this.filterCreatedAtGte = filterCreatedAtGte;
            return this;
        }
        
        /**
         * Set filterCreatedAtGt
         * @param filterCreatedAtGt Return only resources with a created-at greater than the given timestamp. (optional)
         * @return GetBankAccountPaymentsRequestBuilder
         */
        public GetBankAccountPaymentsRequestBuilder filterCreatedAtGt(OffsetDateTime filterCreatedAtGt) {
            this.filterCreatedAtGt = filterCreatedAtGt;
            return this;
        }
        
        /**
         * Build call for getBankAccountPayments
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
            return getBankAccountPaymentsCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, _callback);
        }


        /**
         * Execute getBankAccountPayments request
         * @return PaymentsGetBankAccountPaymentsResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public PaymentsGetBankAccountPaymentsResponse execute() throws ApiException {
            ApiResponse<PaymentsGetBankAccountPaymentsResponse> localVarResp = getBankAccountPaymentsWithHttpInfo(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getBankAccountPayments request with HTTP info returned
         * @return ApiResponse&lt;PaymentsGetBankAccountPaymentsResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public ApiResponse<PaymentsGetBankAccountPaymentsResponse> executeWithHttpInfo() throws ApiException {
            return getBankAccountPaymentsWithHttpInfo(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt);
        }

        /**
         * Execute getBankAccountPayments request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<PaymentsGetBankAccountPaymentsResponse> _callback) throws ApiException {
            return getBankAccountPaymentsAsync(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, _callback);
        }
    }

    /**
     * List bank account payments
     * Lists payments made from a bank account.
     * @param bankAccountId  (required)
     * @return GetBankAccountPaymentsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
     </table>
     */
    public GetBankAccountPaymentsRequestBuilder getBankAccountPayments(String bankAccountId) throws IllegalArgumentException {
        if (bankAccountId == null) throw new IllegalArgumentException("\"bankAccountId\" is required but got null");
            

        return new GetBankAccountPaymentsRequestBuilder(bankAccountId);
    }
    private okhttp3.Call getDetailsCall(String paymentId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/payments/{payment-id}"
            .replace("{" + "payment-id" + "}", localVarApiClient.escapeString(paymentId.toString()));

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
    private okhttp3.Call getDetailsValidateBeforeCall(String paymentId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling getDetails(Async)");
        }

        return getDetailsCall(paymentId, _callback);

    }


    private ApiResponse<PaymentsGetDetailsResponse> getDetailsWithHttpInfo(String paymentId) throws ApiException {
        okhttp3.Call localVarCall = getDetailsValidateBeforeCall(paymentId, null);
        Type localVarReturnType = new TypeToken<PaymentsGetDetailsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getDetailsAsync(String paymentId, final ApiCallback<PaymentsGetDetailsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getDetailsValidateBeforeCall(paymentId, _callback);
        Type localVarReturnType = new TypeToken<PaymentsGetDetailsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetDetailsRequestBuilder {
        private final String paymentId;

        private GetDetailsRequestBuilder(String paymentId) {
            this.paymentId = paymentId;
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
            return getDetailsCall(paymentId, _callback);
        }


        /**
         * Execute getDetails request
         * @return PaymentsGetDetailsResponse
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
        public PaymentsGetDetailsResponse execute() throws ApiException {
            ApiResponse<PaymentsGetDetailsResponse> localVarResp = getDetailsWithHttpInfo(paymentId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getDetails request with HTTP info returned
         * @return ApiResponse&lt;PaymentsGetDetailsResponse&gt;
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
        public ApiResponse<PaymentsGetDetailsResponse> executeWithHttpInfo() throws ApiException {
            return getDetailsWithHttpInfo(paymentId);
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
        public okhttp3.Call executeAsync(final ApiCallback<PaymentsGetDetailsResponse> _callback) throws ApiException {
            return getDetailsAsync(paymentId, _callback);
        }
    }

    /**
     * Get payment
     * Yields payment details
     * @param paymentId  (required)
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
    public GetDetailsRequestBuilder getDetails(String paymentId) throws IllegalArgumentException {
        if (paymentId == null) throw new IllegalArgumentException("\"paymentId\" is required but got null");
            

        return new GetDetailsRequestBuilder(paymentId);
    }
    private okhttp3.Call getSubmissionCall(String submissionId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/submissions/{submission-id}"
            .replace("{" + "submission-id" + "}", localVarApiClient.escapeString(submissionId.toString()));

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
    private okhttp3.Call getSubmissionValidateBeforeCall(String submissionId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'submissionId' is set
        if (submissionId == null) {
            throw new ApiException("Missing the required parameter 'submissionId' when calling getSubmission(Async)");
        }

        return getSubmissionCall(submissionId, _callback);

    }


    private ApiResponse<PaymentsGetSubmissionResponse> getSubmissionWithHttpInfo(String submissionId) throws ApiException {
        okhttp3.Call localVarCall = getSubmissionValidateBeforeCall(submissionId, null);
        Type localVarReturnType = new TypeToken<PaymentsGetSubmissionResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getSubmissionAsync(String submissionId, final ApiCallback<PaymentsGetSubmissionResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getSubmissionValidateBeforeCall(submissionId, _callback);
        Type localVarReturnType = new TypeToken<PaymentsGetSubmissionResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetSubmissionRequestBuilder {
        private final String submissionId;

        private GetSubmissionRequestBuilder(String submissionId) {
            this.submissionId = submissionId;
        }

        /**
         * Build call for getSubmission
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getSubmissionCall(submissionId, _callback);
        }


        /**
         * Execute getSubmission request
         * @return PaymentsGetSubmissionResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public PaymentsGetSubmissionResponse execute() throws ApiException {
            ApiResponse<PaymentsGetSubmissionResponse> localVarResp = getSubmissionWithHttpInfo(submissionId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getSubmission request with HTTP info returned
         * @return ApiResponse&lt;PaymentsGetSubmissionResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PaymentsGetSubmissionResponse> executeWithHttpInfo() throws ApiException {
            return getSubmissionWithHttpInfo(submissionId);
        }

        /**
         * Execute getSubmission request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PaymentsGetSubmissionResponse> _callback) throws ApiException {
            return getSubmissionAsync(submissionId, _callback);
        }
    }

    /**
     * Get payment submission
     * Yields a submission.
     * @param submissionId  (required)
     * @return GetSubmissionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetSubmissionRequestBuilder getSubmission(String submissionId) throws IllegalArgumentException {
        if (submissionId == null) throw new IllegalArgumentException("\"submissionId\" is required but got null");
            

        return new GetSubmissionRequestBuilder(submissionId);
    }
    private okhttp3.Call listAdmissionsCall(String paymentId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/payments/{payment-id}/admissions"
            .replace("{" + "payment-id" + "}", localVarApiClient.escapeString(paymentId.toString()));

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
    private okhttp3.Call listAdmissionsValidateBeforeCall(String paymentId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling listAdmissions(Async)");
        }

        return listAdmissionsCall(paymentId, _callback);

    }


    private ApiResponse<PaymentsListAdmissionsResponse> listAdmissionsWithHttpInfo(String paymentId) throws ApiException {
        okhttp3.Call localVarCall = listAdmissionsValidateBeforeCall(paymentId, null);
        Type localVarReturnType = new TypeToken<PaymentsListAdmissionsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listAdmissionsAsync(String paymentId, final ApiCallback<PaymentsListAdmissionsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listAdmissionsValidateBeforeCall(paymentId, _callback);
        Type localVarReturnType = new TypeToken<PaymentsListAdmissionsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListAdmissionsRequestBuilder {
        private final String paymentId;

        private ListAdmissionsRequestBuilder(String paymentId) {
            this.paymentId = paymentId;
        }

        /**
         * Build call for listAdmissions
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
            return listAdmissionsCall(paymentId, _callback);
        }


        /**
         * Execute listAdmissions request
         * @return PaymentsListAdmissionsResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public PaymentsListAdmissionsResponse execute() throws ApiException {
            ApiResponse<PaymentsListAdmissionsResponse> localVarResp = listAdmissionsWithHttpInfo(paymentId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listAdmissions request with HTTP info returned
         * @return ApiResponse&lt;PaymentsListAdmissionsResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PaymentsListAdmissionsResponse> executeWithHttpInfo() throws ApiException {
            return listAdmissionsWithHttpInfo(paymentId);
        }

        /**
         * Execute listAdmissions request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<PaymentsListAdmissionsResponse> _callback) throws ApiException {
            return listAdmissionsAsync(paymentId, _callback);
        }
    }

    /**
     * List payment admissions
     * Lists admissions for a payment. A payment may have at most one admission.
     * @param paymentId  (required)
     * @return ListAdmissionsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ListAdmissionsRequestBuilder listAdmissions(String paymentId) throws IllegalArgumentException {
        if (paymentId == null) throw new IllegalArgumentException("\"paymentId\" is required but got null");
            

        return new ListAdmissionsRequestBuilder(paymentId);
    }
    private okhttp3.Call listBankAccountAdmissionsCall(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt, List<String> filterAdmissionStatusIn, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/bank/accounts/{bank-account-id}/admissions"
            .replace("{" + "bank-account-id" + "}", localVarApiClient.escapeString(bankAccountId.toString()));

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

        if (pageBefore != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[before]", pageBefore));
        }

        if (pageAfter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[after]", pageAfter));
        }

        if (filterCreatedAtLte != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][lte]", filterCreatedAtLte));
        }

        if (filterCreatedAtLt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][lt]", filterCreatedAtLt));
        }

        if (filterCreatedAtGte != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][gte]", filterCreatedAtGte));
        }

        if (filterCreatedAtGt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][gt]", filterCreatedAtGt));
        }

        if (filterAdmissionStatusIn != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("csv", "filter[admission-status][in]", filterAdmissionStatusIn));
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
    private okhttp3.Call listBankAccountAdmissionsValidateBeforeCall(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt, List<String> filterAdmissionStatusIn, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'bankAccountId' is set
        if (bankAccountId == null) {
            throw new ApiException("Missing the required parameter 'bankAccountId' when calling listBankAccountAdmissions(Async)");
        }

        return listBankAccountAdmissionsCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, filterAdmissionStatusIn, _callback);

    }


    private ApiResponse<PaymentsListBankAccountAdmissionsResponse> listBankAccountAdmissionsWithHttpInfo(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt, List<String> filterAdmissionStatusIn) throws ApiException {
        okhttp3.Call localVarCall = listBankAccountAdmissionsValidateBeforeCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, filterAdmissionStatusIn, null);
        Type localVarReturnType = new TypeToken<PaymentsListBankAccountAdmissionsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listBankAccountAdmissionsAsync(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt, List<String> filterAdmissionStatusIn, final ApiCallback<PaymentsListBankAccountAdmissionsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listBankAccountAdmissionsValidateBeforeCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, filterAdmissionStatusIn, _callback);
        Type localVarReturnType = new TypeToken<PaymentsListBankAccountAdmissionsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListBankAccountAdmissionsRequestBuilder {
        private final String bankAccountId;
        private String sort;
        private Long pageSize;
        private byte[] pageBefore;
        private byte[] pageAfter;
        private OffsetDateTime filterCreatedAtLte;
        private OffsetDateTime filterCreatedAtLt;
        private OffsetDateTime filterCreatedAtGte;
        private OffsetDateTime filterCreatedAtGt;
        private List<String> filterAdmissionStatusIn;

        private ListBankAccountAdmissionsRequestBuilder(String bankAccountId) {
            this.bankAccountId = bankAccountId;
        }

        /**
         * Set sort
         * @param sort  (optional)
         * @return ListBankAccountAdmissionsRequestBuilder
         */
        public ListBankAccountAdmissionsRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return ListBankAccountAdmissionsRequestBuilder
         */
        public ListBankAccountAdmissionsRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListBankAccountAdmissionsRequestBuilder
         */
        public ListBankAccountAdmissionsRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListBankAccountAdmissionsRequestBuilder
         */
        public ListBankAccountAdmissionsRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set filterCreatedAtLte
         * @param filterCreatedAtLte Return only resources with a created-at less than or equal to the given timestamp. (optional)
         * @return ListBankAccountAdmissionsRequestBuilder
         */
        public ListBankAccountAdmissionsRequestBuilder filterCreatedAtLte(OffsetDateTime filterCreatedAtLte) {
            this.filterCreatedAtLte = filterCreatedAtLte;
            return this;
        }
        
        /**
         * Set filterCreatedAtLt
         * @param filterCreatedAtLt Return only resources with a created-at less than the given timestamp. (optional)
         * @return ListBankAccountAdmissionsRequestBuilder
         */
        public ListBankAccountAdmissionsRequestBuilder filterCreatedAtLt(OffsetDateTime filterCreatedAtLt) {
            this.filterCreatedAtLt = filterCreatedAtLt;
            return this;
        }
        
        /**
         * Set filterCreatedAtGte
         * @param filterCreatedAtGte Return only resources with a created-at greater than or equal to the given timestamp. (optional)
         * @return ListBankAccountAdmissionsRequestBuilder
         */
        public ListBankAccountAdmissionsRequestBuilder filterCreatedAtGte(OffsetDateTime filterCreatedAtGte) {
            this.filterCreatedAtGte = filterCreatedAtGte;
            return this;
        }
        
        /**
         * Set filterCreatedAtGt
         * @param filterCreatedAtGt Return only resources with a created-at greater than the given timestamp. (optional)
         * @return ListBankAccountAdmissionsRequestBuilder
         */
        public ListBankAccountAdmissionsRequestBuilder filterCreatedAtGt(OffsetDateTime filterCreatedAtGt) {
            this.filterCreatedAtGt = filterCreatedAtGt;
            return this;
        }
        
        /**
         * Set filterAdmissionStatusIn
         * @param filterAdmissionStatusIn  (optional)
         * @return ListBankAccountAdmissionsRequestBuilder
         */
        public ListBankAccountAdmissionsRequestBuilder filterAdmissionStatusIn(List<String> filterAdmissionStatusIn) {
            this.filterAdmissionStatusIn = filterAdmissionStatusIn;
            return this;
        }
        
        /**
         * Build call for listBankAccountAdmissions
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
            return listBankAccountAdmissionsCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, filterAdmissionStatusIn, _callback);
        }


        /**
         * Execute listBankAccountAdmissions request
         * @return PaymentsListBankAccountAdmissionsResponse
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
        public PaymentsListBankAccountAdmissionsResponse execute() throws ApiException {
            ApiResponse<PaymentsListBankAccountAdmissionsResponse> localVarResp = listBankAccountAdmissionsWithHttpInfo(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, filterAdmissionStatusIn);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listBankAccountAdmissions request with HTTP info returned
         * @return ApiResponse&lt;PaymentsListBankAccountAdmissionsResponse&gt;
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
        public ApiResponse<PaymentsListBankAccountAdmissionsResponse> executeWithHttpInfo() throws ApiException {
            return listBankAccountAdmissionsWithHttpInfo(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, filterAdmissionStatusIn);
        }

        /**
         * Execute listBankAccountAdmissions request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<PaymentsListBankAccountAdmissionsResponse> _callback) throws ApiException {
            return listBankAccountAdmissionsAsync(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, filterAdmissionStatusIn, _callback);
        }
    }

    /**
     * List bank account admissions
     * Lists admissions targeting a bank account
     * @param bankAccountId  (required)
     * @return ListBankAccountAdmissionsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ListBankAccountAdmissionsRequestBuilder listBankAccountAdmissions(String bankAccountId) throws IllegalArgumentException {
        if (bankAccountId == null) throw new IllegalArgumentException("\"bankAccountId\" is required but got null");
            

        return new ListBankAccountAdmissionsRequestBuilder(bankAccountId);
    }
    private okhttp3.Call listSubmissionsCall(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, List<String> filterSubmissionStatusIn, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/bank/accounts/{bank-account-id}/submissions"
            .replace("{" + "bank-account-id" + "}", localVarApiClient.escapeString(bankAccountId.toString()));

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

        if (pageBefore != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[before]", pageBefore));
        }

        if (pageAfter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[after]", pageAfter));
        }

        if (filterSubmissionStatusIn != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("csv", "filter[submission-status][in]", filterSubmissionStatusIn));
        }

        if (filterCreatedAtLte != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][lte]", filterCreatedAtLte));
        }

        if (filterCreatedAtLt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][lt]", filterCreatedAtLt));
        }

        if (filterCreatedAtGte != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][gte]", filterCreatedAtGte));
        }

        if (filterCreatedAtGt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[created-at][gt]", filterCreatedAtGt));
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
    private okhttp3.Call listSubmissionsValidateBeforeCall(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, List<String> filterSubmissionStatusIn, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'bankAccountId' is set
        if (bankAccountId == null) {
            throw new ApiException("Missing the required parameter 'bankAccountId' when calling listSubmissions(Async)");
        }

        return listSubmissionsCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterSubmissionStatusIn, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, _callback);

    }


    private ApiResponse<PaymentsListSubmissionsResponse> listSubmissionsWithHttpInfo(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, List<String> filterSubmissionStatusIn, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt) throws ApiException {
        okhttp3.Call localVarCall = listSubmissionsValidateBeforeCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterSubmissionStatusIn, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, null);
        Type localVarReturnType = new TypeToken<PaymentsListSubmissionsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listSubmissionsAsync(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, List<String> filterSubmissionStatusIn, OffsetDateTime filterCreatedAtLte, OffsetDateTime filterCreatedAtLt, OffsetDateTime filterCreatedAtGte, OffsetDateTime filterCreatedAtGt, final ApiCallback<PaymentsListSubmissionsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listSubmissionsValidateBeforeCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterSubmissionStatusIn, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, _callback);
        Type localVarReturnType = new TypeToken<PaymentsListSubmissionsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListSubmissionsRequestBuilder {
        private final String bankAccountId;
        private String sort;
        private Long pageSize;
        private byte[] pageBefore;
        private byte[] pageAfter;
        private List<String> filterSubmissionStatusIn;
        private OffsetDateTime filterCreatedAtLte;
        private OffsetDateTime filterCreatedAtLt;
        private OffsetDateTime filterCreatedAtGte;
        private OffsetDateTime filterCreatedAtGt;

        private ListSubmissionsRequestBuilder(String bankAccountId) {
            this.bankAccountId = bankAccountId;
        }

        /**
         * Set sort
         * @param sort  (optional)
         * @return ListSubmissionsRequestBuilder
         */
        public ListSubmissionsRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return ListSubmissionsRequestBuilder
         */
        public ListSubmissionsRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListSubmissionsRequestBuilder
         */
        public ListSubmissionsRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListSubmissionsRequestBuilder
         */
        public ListSubmissionsRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set filterSubmissionStatusIn
         * @param filterSubmissionStatusIn  (optional)
         * @return ListSubmissionsRequestBuilder
         */
        public ListSubmissionsRequestBuilder filterSubmissionStatusIn(List<String> filterSubmissionStatusIn) {
            this.filterSubmissionStatusIn = filterSubmissionStatusIn;
            return this;
        }
        
        /**
         * Set filterCreatedAtLte
         * @param filterCreatedAtLte Return only resources with a created-at less than or equal to the given timestamp. (optional)
         * @return ListSubmissionsRequestBuilder
         */
        public ListSubmissionsRequestBuilder filterCreatedAtLte(OffsetDateTime filterCreatedAtLte) {
            this.filterCreatedAtLte = filterCreatedAtLte;
            return this;
        }
        
        /**
         * Set filterCreatedAtLt
         * @param filterCreatedAtLt Return only resources with a created-at less than the given timestamp. (optional)
         * @return ListSubmissionsRequestBuilder
         */
        public ListSubmissionsRequestBuilder filterCreatedAtLt(OffsetDateTime filterCreatedAtLt) {
            this.filterCreatedAtLt = filterCreatedAtLt;
            return this;
        }
        
        /**
         * Set filterCreatedAtGte
         * @param filterCreatedAtGte Return only resources with a created-at greater than or equal to the given timestamp. (optional)
         * @return ListSubmissionsRequestBuilder
         */
        public ListSubmissionsRequestBuilder filterCreatedAtGte(OffsetDateTime filterCreatedAtGte) {
            this.filterCreatedAtGte = filterCreatedAtGte;
            return this;
        }
        
        /**
         * Set filterCreatedAtGt
         * @param filterCreatedAtGt Return only resources with a created-at greater than the given timestamp. (optional)
         * @return ListSubmissionsRequestBuilder
         */
        public ListSubmissionsRequestBuilder filterCreatedAtGt(OffsetDateTime filterCreatedAtGt) {
            this.filterCreatedAtGt = filterCreatedAtGt;
            return this;
        }
        
        /**
         * Build call for listSubmissions
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
            return listSubmissionsCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterSubmissionStatusIn, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, _callback);
        }


        /**
         * Execute listSubmissions request
         * @return PaymentsListSubmissionsResponse
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
        public PaymentsListSubmissionsResponse execute() throws ApiException {
            ApiResponse<PaymentsListSubmissionsResponse> localVarResp = listSubmissionsWithHttpInfo(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterSubmissionStatusIn, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listSubmissions request with HTTP info returned
         * @return ApiResponse&lt;PaymentsListSubmissionsResponse&gt;
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
        public ApiResponse<PaymentsListSubmissionsResponse> executeWithHttpInfo() throws ApiException {
            return listSubmissionsWithHttpInfo(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterSubmissionStatusIn, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt);
        }

        /**
         * Execute listSubmissions request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<PaymentsListSubmissionsResponse> _callback) throws ApiException {
            return listSubmissionsAsync(bankAccountId, sort, pageSize, pageBefore, pageAfter, filterSubmissionStatusIn, filterCreatedAtLte, filterCreatedAtLt, filterCreatedAtGte, filterCreatedAtGt, _callback);
        }
    }

    /**
     * List bank account submissions
     * Lists submissions originating from a bank account
     * @param bankAccountId  (required)
     * @return ListSubmissionsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ListSubmissionsRequestBuilder listSubmissions(String bankAccountId) throws IllegalArgumentException {
        if (bankAccountId == null) throw new IllegalArgumentException("\"bankAccountId\" is required but got null");
            

        return new ListSubmissionsRequestBuilder(bankAccountId);
    }
    private okhttp3.Call listSubmissions_0Call(String paymentId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/payments/{payment-id}/submissions"
            .replace("{" + "payment-id" + "}", localVarApiClient.escapeString(paymentId.toString()));

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
    private okhttp3.Call listSubmissions_0ValidateBeforeCall(String paymentId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling listSubmissions_0(Async)");
        }

        return listSubmissions_0Call(paymentId, _callback);

    }


    private ApiResponse<PaymentsListSubmissions200Response> listSubmissions_0WithHttpInfo(String paymentId) throws ApiException {
        okhttp3.Call localVarCall = listSubmissions_0ValidateBeforeCall(paymentId, null);
        Type localVarReturnType = new TypeToken<PaymentsListSubmissions200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listSubmissions_0Async(String paymentId, final ApiCallback<PaymentsListSubmissions200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = listSubmissions_0ValidateBeforeCall(paymentId, _callback);
        Type localVarReturnType = new TypeToken<PaymentsListSubmissions200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListSubmissions0RequestBuilder {
        private final String paymentId;

        private ListSubmissions0RequestBuilder(String paymentId) {
            this.paymentId = paymentId;
        }

        /**
         * Build call for listSubmissions_0
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
            return listSubmissions_0Call(paymentId, _callback);
        }


        /**
         * Execute listSubmissions_0 request
         * @return PaymentsListSubmissions200Response
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public PaymentsListSubmissions200Response execute() throws ApiException {
            ApiResponse<PaymentsListSubmissions200Response> localVarResp = listSubmissions_0WithHttpInfo(paymentId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listSubmissions_0 request with HTTP info returned
         * @return ApiResponse&lt;PaymentsListSubmissions200Response&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PaymentsListSubmissions200Response> executeWithHttpInfo() throws ApiException {
            return listSubmissions_0WithHttpInfo(paymentId);
        }

        /**
         * Execute listSubmissions_0 request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<PaymentsListSubmissions200Response> _callback) throws ApiException {
            return listSubmissions_0Async(paymentId, _callback);
        }
    }

    /**
     * List payment submissions
     * Lists submissions for a payment. The presence of a submission means that the payment has been submitted.
     * @param paymentId  (required)
     * @return ListSubmissions0RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ListSubmissions0RequestBuilder listSubmissions_0(String paymentId) throws IllegalArgumentException {
        if (paymentId == null) throw new IllegalArgumentException("\"paymentId\" is required but got null");
            

        return new ListSubmissions0RequestBuilder(paymentId);
    }
    private okhttp3.Call submitPaymentSubmissionCall(String paymentId, PaymentsSubmitPaymentSubmissionRequest paymentsSubmitPaymentSubmissionRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = paymentsSubmitPaymentSubmissionRequest;

        // create path and map variables
        String localVarPath = "/v0/payments/{payment-id}/submissions"
            .replace("{" + "payment-id" + "}", localVarApiClient.escapeString(paymentId.toString()));

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
    private okhttp3.Call submitPaymentSubmissionValidateBeforeCall(String paymentId, PaymentsSubmitPaymentSubmissionRequest paymentsSubmitPaymentSubmissionRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling submitPaymentSubmission(Async)");
        }

        // verify the required parameter 'paymentsSubmitPaymentSubmissionRequest' is set
        if (paymentsSubmitPaymentSubmissionRequest == null) {
            throw new ApiException("Missing the required parameter 'paymentsSubmitPaymentSubmissionRequest' when calling submitPaymentSubmission(Async)");
        }

        return submitPaymentSubmissionCall(paymentId, paymentsSubmitPaymentSubmissionRequest, _callback);

    }


    private ApiResponse<PaymentsSubmitPaymentSubmissionResponse> submitPaymentSubmissionWithHttpInfo(String paymentId, PaymentsSubmitPaymentSubmissionRequest paymentsSubmitPaymentSubmissionRequest) throws ApiException {
        okhttp3.Call localVarCall = submitPaymentSubmissionValidateBeforeCall(paymentId, paymentsSubmitPaymentSubmissionRequest, null);
        Type localVarReturnType = new TypeToken<PaymentsSubmitPaymentSubmissionResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call submitPaymentSubmissionAsync(String paymentId, PaymentsSubmitPaymentSubmissionRequest paymentsSubmitPaymentSubmissionRequest, final ApiCallback<PaymentsSubmitPaymentSubmissionResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = submitPaymentSubmissionValidateBeforeCall(paymentId, paymentsSubmitPaymentSubmissionRequest, _callback);
        Type localVarReturnType = new TypeToken<PaymentsSubmitPaymentSubmissionResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SubmitPaymentSubmissionRequestBuilder {
        private final String paymentId;
        private String paymentScheme;

        private SubmitPaymentSubmissionRequestBuilder(String paymentId) {
            this.paymentId = paymentId;
        }

        /**
         * Set paymentScheme
         * @param paymentScheme Specifies the scheme over which a payment is executed. (optional)
         * @return SubmitPaymentSubmissionRequestBuilder
         */
        public SubmitPaymentSubmissionRequestBuilder paymentScheme(String paymentScheme) {
            this.paymentScheme = paymentScheme;
            return this;
        }
        
        /**
         * Build call for submitPaymentSubmission
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
            <tr><td> 410 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> An error occurred when trying to submit the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            PaymentsSubmitPaymentSubmissionRequest paymentsSubmitPaymentSubmissionRequest = buildBodyParams();
            return submitPaymentSubmissionCall(paymentId, paymentsSubmitPaymentSubmissionRequest, _callback);
        }

        private PaymentsSubmitPaymentSubmissionRequest buildBodyParams() {
            PaymentsSubmitPaymentSubmissionRequest paymentsSubmitPaymentSubmissionRequest = new PaymentsSubmitPaymentSubmissionRequest();
            if (this.paymentScheme != null)
            paymentsSubmitPaymentSubmissionRequest.paymentScheme(PaymentsSubmitPaymentSubmissionRequest.PaymentSchemeEnum.fromValue(this.paymentScheme));
            return paymentsSubmitPaymentSubmissionRequest;
        }

        /**
         * Execute submitPaymentSubmission request
         * @return PaymentsSubmitPaymentSubmissionResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 410 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> An error occurred when trying to submit the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. </td><td>  -  </td></tr>
         </table>
         */
        public PaymentsSubmitPaymentSubmissionResponse execute() throws ApiException {
            PaymentsSubmitPaymentSubmissionRequest paymentsSubmitPaymentSubmissionRequest = buildBodyParams();
            ApiResponse<PaymentsSubmitPaymentSubmissionResponse> localVarResp = submitPaymentSubmissionWithHttpInfo(paymentId, paymentsSubmitPaymentSubmissionRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute submitPaymentSubmission request with HTTP info returned
         * @return ApiResponse&lt;PaymentsSubmitPaymentSubmissionResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 410 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> An error occurred when trying to submit the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PaymentsSubmitPaymentSubmissionResponse> executeWithHttpInfo() throws ApiException {
            PaymentsSubmitPaymentSubmissionRequest paymentsSubmitPaymentSubmissionRequest = buildBodyParams();
            return submitPaymentSubmissionWithHttpInfo(paymentId, paymentsSubmitPaymentSubmissionRequest);
        }

        /**
         * Execute submitPaymentSubmission request (asynchronously)
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
            <tr><td> 410 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> An error occurred when trying to submit the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PaymentsSubmitPaymentSubmissionResponse> _callback) throws ApiException {
            PaymentsSubmitPaymentSubmissionRequest paymentsSubmitPaymentSubmissionRequest = buildBodyParams();
            return submitPaymentSubmissionAsync(paymentId, paymentsSubmitPaymentSubmissionRequest, _callback);
        }
    }

    /**
     * Submit payment
     * Submits a previously created payment for execution.
     * @param paymentId  (required)
     * @param paymentsSubmitPaymentSubmissionRequest  (required)
     * @return SubmitPaymentSubmissionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 410 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> An error occurred when trying to submit the payment. See [https://docs.griffin.com/docs/errors/payment](https://docs.griffin.com/docs/errors/payment) for details. </td><td>  -  </td></tr>
     </table>
     */
    public SubmitPaymentSubmissionRequestBuilder submitPaymentSubmission(String paymentId) throws IllegalArgumentException {
        if (paymentId == null) throw new IllegalArgumentException("\"paymentId\" is required but got null");
            

        return new SubmitPaymentSubmissionRequestBuilder(paymentId);
    }
}
