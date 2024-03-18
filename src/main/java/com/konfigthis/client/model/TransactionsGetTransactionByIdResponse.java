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


package com.konfigthis.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.konfigthis.client.model.AccountBalanceProperty4;
import com.konfigthis.client.model.BalanceChangeProperty1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.konfigthis.client.JSON;

/**
 * TransactionsGetTransactionByIdResponse
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class TransactionsGetTransactionByIdResponse {
  public static final String SERIALIZED_NAME_ACCOUNT_TRANSACTION_URL = "account-transaction-url";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_TRANSACTION_URL)
  private String accountTransactionUrl;

  public static final String SERIALIZED_NAME_POST_DATETIME = "post-datetime";
  @SerializedName(SERIALIZED_NAME_POST_DATETIME)
  private OffsetDateTime postDatetime;

  /**
   * Specifies the direction of a balance change.
   */
  @JsonAdapter(BalanceChangeDirectionEnum.Adapter.class)
 public enum BalanceChangeDirectionEnum {
    CREDIT("credit"),
    
    DEBIT("debit");

    private String value;

    BalanceChangeDirectionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BalanceChangeDirectionEnum fromValue(String value) {
      for (BalanceChangeDirectionEnum b : BalanceChangeDirectionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BalanceChangeDirectionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BalanceChangeDirectionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BalanceChangeDirectionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BalanceChangeDirectionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BALANCE_CHANGE_DIRECTION = "balance-change-direction";
  @SerializedName(SERIALIZED_NAME_BALANCE_CHANGE_DIRECTION)
  private BalanceChangeDirectionEnum balanceChangeDirection;

  /**
   * Specifies the origin of a balance change, for example a payment
   */
  @JsonAdapter(TransactionOriginTypeEnum.Adapter.class)
 public enum TransactionOriginTypeEnum {
    INTEREST("interest"),
    
    DEPOSIT("deposit"),
    
    FEE("fee"),
    
    TRANSFER("transfer"),
    
    PAYMENT("payment"),
    
    COMMISSION("commission");

    private String value;

    TransactionOriginTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TransactionOriginTypeEnum fromValue(String value) {
      for (TransactionOriginTypeEnum b : TransactionOriginTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TransactionOriginTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TransactionOriginTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TransactionOriginTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TransactionOriginTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TRANSACTION_ORIGIN_TYPE = "transaction-origin-type";
  @SerializedName(SERIALIZED_NAME_TRANSACTION_ORIGIN_TYPE)
  private TransactionOriginTypeEnum transactionOriginType;

  public static final String SERIALIZED_NAME_PAYMENT_URL = "payment-url";
  @SerializedName(SERIALIZED_NAME_PAYMENT_URL)
  private String paymentUrl;

  public static final String SERIALIZED_NAME_REFERENCE = "reference";
  @SerializedName(SERIALIZED_NAME_REFERENCE)
  private String reference;

  public static final String SERIALIZED_NAME_ACCOUNT_URL = "account-url";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_URL)
  private String accountUrl;

  public static final String SERIALIZED_NAME_BALANCE_CHANGE = "balance-change";
  @SerializedName(SERIALIZED_NAME_BALANCE_CHANGE)
  private BalanceChangeProperty1 balanceChange;

  public static final String SERIALIZED_NAME_ACCOUNT_BALANCE = "account-balance";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_BALANCE)
  private AccountBalanceProperty4 accountBalance;

  public TransactionsGetTransactionByIdResponse() {
  }

  public TransactionsGetTransactionByIdResponse accountTransactionUrl(String accountTransactionUrl) {
    
    
    
    
    this.accountTransactionUrl = accountTransactionUrl;
    return this;
  }

   /**
   * Link to the transaction resource.
   * @return accountTransactionUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Link to the transaction resource.")

  public String getAccountTransactionUrl() {
    return accountTransactionUrl;
  }


  public void setAccountTransactionUrl(String accountTransactionUrl) {
    
    
    
    this.accountTransactionUrl = accountTransactionUrl;
  }


  public TransactionsGetTransactionByIdResponse postDatetime(OffsetDateTime postDatetime) {
    
    
    
    
    this.postDatetime = postDatetime;
    return this;
  }

   /**
   * When the transaction was posted.
   * @return postDatetime
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "When the transaction was posted.")

  public OffsetDateTime getPostDatetime() {
    return postDatetime;
  }


  public void setPostDatetime(OffsetDateTime postDatetime) {
    
    
    
    this.postDatetime = postDatetime;
  }


  public TransactionsGetTransactionByIdResponse balanceChangeDirection(BalanceChangeDirectionEnum balanceChangeDirection) {
    
    
    
    
    this.balanceChangeDirection = balanceChangeDirection;
    return this;
  }

   /**
   * Specifies the direction of a balance change.
   * @return balanceChangeDirection
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specifies the direction of a balance change.")

  public BalanceChangeDirectionEnum getBalanceChangeDirection() {
    return balanceChangeDirection;
  }


  public void setBalanceChangeDirection(BalanceChangeDirectionEnum balanceChangeDirection) {
    
    
    
    this.balanceChangeDirection = balanceChangeDirection;
  }


  public TransactionsGetTransactionByIdResponse transactionOriginType(TransactionOriginTypeEnum transactionOriginType) {
    
    
    
    
    this.transactionOriginType = transactionOriginType;
    return this;
  }

   /**
   * Specifies the origin of a balance change, for example a payment
   * @return transactionOriginType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specifies the origin of a balance change, for example a payment")

  public TransactionOriginTypeEnum getTransactionOriginType() {
    return transactionOriginType;
  }


  public void setTransactionOriginType(TransactionOriginTypeEnum transactionOriginType) {
    
    
    
    this.transactionOriginType = transactionOriginType;
  }


  public TransactionsGetTransactionByIdResponse paymentUrl(String paymentUrl) {
    
    
    
    
    this.paymentUrl = paymentUrl;
    return this;
  }

   /**
   * Link to the payment resource.
   * @return paymentUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/payments/pm.ICAgICAgcGF5bWVudC1pZA", value = "Link to the payment resource.")

  public String getPaymentUrl() {
    return paymentUrl;
  }


  public void setPaymentUrl(String paymentUrl) {
    
    
    
    this.paymentUrl = paymentUrl;
  }


  public TransactionsGetTransactionByIdResponse reference(String reference) {
    
    
    
    
    this.reference = reference;
    return this;
  }

   /**
   * Get reference
   * @return reference
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getReference() {
    return reference;
  }


  public void setReference(String reference) {
    
    
    
    this.reference = reference;
  }


  public TransactionsGetTransactionByIdResponse accountUrl(String accountUrl) {
    
    
    
    
    this.accountUrl = accountUrl;
    return this;
  }

   /**
   * Link to the bank account resource.
   * @return accountUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/bank/accounts/ba.IGJhbmstYWNjb3VudC1pZA", required = true, value = "Link to the bank account resource.")

  public String getAccountUrl() {
    return accountUrl;
  }


  public void setAccountUrl(String accountUrl) {
    
    
    
    this.accountUrl = accountUrl;
  }


  public TransactionsGetTransactionByIdResponse balanceChange(BalanceChangeProperty1 balanceChange) {
    
    
    
    
    this.balanceChange = balanceChange;
    return this;
  }

   /**
   * Get balanceChange
   * @return balanceChange
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public BalanceChangeProperty1 getBalanceChange() {
    return balanceChange;
  }


  public void setBalanceChange(BalanceChangeProperty1 balanceChange) {
    
    
    
    this.balanceChange = balanceChange;
  }


  public TransactionsGetTransactionByIdResponse accountBalance(AccountBalanceProperty4 accountBalance) {
    
    
    
    
    this.accountBalance = accountBalance;
    return this;
  }

   /**
   * Get accountBalance
   * @return accountBalance
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public AccountBalanceProperty4 getAccountBalance() {
    return accountBalance;
  }


  public void setAccountBalance(AccountBalanceProperty4 accountBalance) {
    
    
    
    this.accountBalance = accountBalance;
  }

  /**
   * A container for additional, undeclared properties.
   * This is a holder for any undeclared properties as specified with
   * the 'additionalProperties' keyword in the OAS document.
   */
  private Map<String, Object> additionalProperties;

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * If the property does not already exist, create it otherwise replace it.
   *
   * @param key name of the property
   * @param value value of the property
   * @return the TransactionsGetTransactionByIdResponse instance itself
   */
  public TransactionsGetTransactionByIdResponse putAdditionalProperty(String key, Object value) {
    if (this.additionalProperties == null) {
        this.additionalProperties = new HashMap<String, Object>();
    }
    this.additionalProperties.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) property.
   *
   * @return a map of objects
   */
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   *
   * @param key name of the property
   * @return an object
   */
  public Object getAdditionalProperty(String key) {
    if (this.additionalProperties == null) {
        return null;
    }
    return this.additionalProperties.get(key);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionsGetTransactionByIdResponse transactionsGetTransactionByIdResponse = (TransactionsGetTransactionByIdResponse) o;
    return Objects.equals(this.accountTransactionUrl, transactionsGetTransactionByIdResponse.accountTransactionUrl) &&
        Objects.equals(this.postDatetime, transactionsGetTransactionByIdResponse.postDatetime) &&
        Objects.equals(this.balanceChangeDirection, transactionsGetTransactionByIdResponse.balanceChangeDirection) &&
        Objects.equals(this.transactionOriginType, transactionsGetTransactionByIdResponse.transactionOriginType) &&
        Objects.equals(this.paymentUrl, transactionsGetTransactionByIdResponse.paymentUrl) &&
        Objects.equals(this.reference, transactionsGetTransactionByIdResponse.reference) &&
        Objects.equals(this.accountUrl, transactionsGetTransactionByIdResponse.accountUrl) &&
        Objects.equals(this.balanceChange, transactionsGetTransactionByIdResponse.balanceChange) &&
        Objects.equals(this.accountBalance, transactionsGetTransactionByIdResponse.accountBalance)&&
        Objects.equals(this.additionalProperties, transactionsGetTransactionByIdResponse.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountTransactionUrl, postDatetime, balanceChangeDirection, transactionOriginType, paymentUrl, reference, accountUrl, balanceChange, accountBalance, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionsGetTransactionByIdResponse {\n");
    sb.append("    accountTransactionUrl: ").append(toIndentedString(accountTransactionUrl)).append("\n");
    sb.append("    postDatetime: ").append(toIndentedString(postDatetime)).append("\n");
    sb.append("    balanceChangeDirection: ").append(toIndentedString(balanceChangeDirection)).append("\n");
    sb.append("    transactionOriginType: ").append(toIndentedString(transactionOriginType)).append("\n");
    sb.append("    paymentUrl: ").append(toIndentedString(paymentUrl)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    accountUrl: ").append(toIndentedString(accountUrl)).append("\n");
    sb.append("    balanceChange: ").append(toIndentedString(balanceChange)).append("\n");
    sb.append("    accountBalance: ").append(toIndentedString(accountBalance)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("account-transaction-url");
    openapiFields.add("post-datetime");
    openapiFields.add("balance-change-direction");
    openapiFields.add("transaction-origin-type");
    openapiFields.add("payment-url");
    openapiFields.add("reference");
    openapiFields.add("account-url");
    openapiFields.add("balance-change");
    openapiFields.add("account-balance");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("account-transaction-url");
    openapiRequiredFields.add("post-datetime");
    openapiRequiredFields.add("balance-change-direction");
    openapiRequiredFields.add("transaction-origin-type");
    openapiRequiredFields.add("account-url");
    openapiRequiredFields.add("balance-change");
    openapiRequiredFields.add("account-balance");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to TransactionsGetTransactionByIdResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!TransactionsGetTransactionByIdResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TransactionsGetTransactionByIdResponse is not found in the empty JSON string", TransactionsGetTransactionByIdResponse.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : TransactionsGetTransactionByIdResponse.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("account-transaction-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-transaction-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-transaction-url").toString()));
      }
      if (!jsonObj.get("balance-change-direction").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `balance-change-direction` to be a primitive type in the JSON string but got `%s`", jsonObj.get("balance-change-direction").toString()));
      }
      if (!jsonObj.get("transaction-origin-type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `transaction-origin-type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("transaction-origin-type").toString()));
      }
      if ((jsonObj.get("payment-url") != null && !jsonObj.get("payment-url").isJsonNull()) && !jsonObj.get("payment-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payment-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payment-url").toString()));
      }
      if ((jsonObj.get("reference") != null && !jsonObj.get("reference").isJsonNull()) && !jsonObj.get("reference").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `reference` to be a primitive type in the JSON string but got `%s`", jsonObj.get("reference").toString()));
      }
      if (!jsonObj.get("account-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-url").toString()));
      }
      // validate the required field `balance-change`
      BalanceChangeProperty1.validateJsonObject(jsonObj.getAsJsonObject("balance-change"));
      // validate the required field `account-balance`
      AccountBalanceProperty4.validateJsonObject(jsonObj.getAsJsonObject("account-balance"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TransactionsGetTransactionByIdResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TransactionsGetTransactionByIdResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TransactionsGetTransactionByIdResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TransactionsGetTransactionByIdResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<TransactionsGetTransactionByIdResponse>() {
           @Override
           public void write(JsonWriter out, TransactionsGetTransactionByIdResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             obj.remove("additionalProperties");
             // serialize additonal properties
             if (value.getAdditionalProperties() != null) {
               for (Map.Entry<String, Object> entry : value.getAdditionalProperties().entrySet()) {
                 if (entry.getValue() instanceof String)
                   obj.addProperty(entry.getKey(), (String) entry.getValue());
                 else if (entry.getValue() instanceof Number)
                   obj.addProperty(entry.getKey(), (Number) entry.getValue());
                 else if (entry.getValue() instanceof Boolean)
                   obj.addProperty(entry.getKey(), (Boolean) entry.getValue());
                 else if (entry.getValue() instanceof Character)
                   obj.addProperty(entry.getKey(), (Character) entry.getValue());
                 else {
                   obj.add(entry.getKey(), gson.toJsonTree(entry.getValue()).getAsJsonObject());
                 }
               }
             }
             elementAdapter.write(out, obj);
           }

           @Override
           public TransactionsGetTransactionByIdResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             TransactionsGetTransactionByIdResponse instance = thisAdapter.fromJsonTree(jsonObj);
             for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
               if (!openapiFields.contains(entry.getKey())) {
                 if (entry.getValue().isJsonPrimitive()) { // primitive type
                   if (entry.getValue().getAsJsonPrimitive().isString())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsString());
                   else if (entry.getValue().getAsJsonPrimitive().isNumber())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsNumber());
                   else if (entry.getValue().getAsJsonPrimitive().isBoolean())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsBoolean());
                   else
                     throw new IllegalArgumentException(String.format("The field `%s` has unknown primitive type. Value: %s", entry.getKey(), entry.getValue().toString()));
                 } else if (entry.getValue().isJsonArray()) {
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), List.class));
                 } else { // JSON object
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), HashMap.class));
                 }
               }
             }
             return instance;
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TransactionsGetTransactionByIdResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TransactionsGetTransactionByIdResponse
  * @throws IOException if the JSON string is invalid with respect to TransactionsGetTransactionByIdResponse
  */
  public static TransactionsGetTransactionByIdResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TransactionsGetTransactionByIdResponse.class);
  }

 /**
  * Convert an instance of TransactionsGetTransactionByIdResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
