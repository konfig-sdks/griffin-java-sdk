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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

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
 * PayeeProperty4
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PayeeProperty4 {
  public static final String SERIALIZED_NAME_PAYEE_URL = "payee-url";
  @SerializedName(SERIALIZED_NAME_PAYEE_URL)
  private String payeeUrl;

  /**
   * Gets or Sets creditorType
   */
  @JsonAdapter(CreditorTypeEnum.Adapter.class)
 public enum CreditorTypeEnum {
    PAYEE("payee");

    private String value;

    CreditorTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CreditorTypeEnum fromValue(String value) {
      for (CreditorTypeEnum b : CreditorTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CreditorTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CreditorTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CreditorTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CreditorTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CREDITOR_TYPE = "creditor-type";
  @SerializedName(SERIALIZED_NAME_CREDITOR_TYPE)
  private CreditorTypeEnum creditorType;

  public static final String SERIALIZED_NAME_ACCOUNT_URL = "account-url";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_URL)
  private String accountUrl;

  public static final String SERIALIZED_NAME_ACCOUNT_HOLDER = "account-holder";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_HOLDER)
  private String accountHolder;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "account-number";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  /**
   * Gets or Sets accountNumberCode
   */
  @JsonAdapter(AccountNumberCodeEnum.Adapter.class)
 public enum AccountNumberCodeEnum {
    BBAN("bban");

    private String value;

    AccountNumberCodeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static AccountNumberCodeEnum fromValue(String value) {
      for (AccountNumberCodeEnum b : AccountNumberCodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<AccountNumberCodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AccountNumberCodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public AccountNumberCodeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return AccountNumberCodeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER_CODE = "account-number-code";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER_CODE)
  private AccountNumberCodeEnum accountNumberCode;

  public static final String SERIALIZED_NAME_BANK_ID = "bank-id";
  @SerializedName(SERIALIZED_NAME_BANK_ID)
  private String bankId;

  /**
   * Gets or Sets bankIdCode
   */
  @JsonAdapter(BankIdCodeEnum.Adapter.class)
 public enum BankIdCodeEnum {
    GBDSC("gbdsc");

    private String value;

    BankIdCodeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BankIdCodeEnum fromValue(String value) {
      for (BankIdCodeEnum b : BankIdCodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BankIdCodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BankIdCodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BankIdCodeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BankIdCodeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BANK_ID_CODE = "bank-id-code";
  @SerializedName(SERIALIZED_NAME_BANK_ID_CODE)
  private BankIdCodeEnum bankIdCode;

  public PayeeProperty4() {
  }

  public PayeeProperty4 payeeUrl(String payeeUrl) {
    
    
    
    
    this.payeeUrl = payeeUrl;
    return this;
  }

   /**
   * Link to the [payee](http://docs.griffin.com).
   * @return payeeUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/payees/pe.ICAgICAgICBwYXllZS1pZA", value = "Link to the [payee](http://docs.griffin.com).")

  public String getPayeeUrl() {
    return payeeUrl;
  }


  public void setPayeeUrl(String payeeUrl) {
    
    
    
    this.payeeUrl = payeeUrl;
  }


  public PayeeProperty4 creditorType(CreditorTypeEnum creditorType) {
    
    
    
    
    this.creditorType = creditorType;
    return this;
  }

   /**
   * Get creditorType
   * @return creditorType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public CreditorTypeEnum getCreditorType() {
    return creditorType;
  }


  public void setCreditorType(CreditorTypeEnum creditorType) {
    
    
    
    this.creditorType = creditorType;
  }


  public PayeeProperty4 accountUrl(String accountUrl) {
    
    
    
    
    this.accountUrl = accountUrl;
    return this;
  }

   /**
   * Link to the bank account resource.
   * @return accountUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/bank/accounts/ba.IGJhbmstYWNjb3VudC1pZA", value = "Link to the bank account resource.")

  public String getAccountUrl() {
    return accountUrl;
  }


  public void setAccountUrl(String accountUrl) {
    
    
    
    this.accountUrl = accountUrl;
  }


  public PayeeProperty4 accountHolder(String accountHolder) {
    
    
    if (accountHolder != null && accountHolder.length() < 1) {
      throw new IllegalArgumentException("Invalid value for accountHolder. Length must be greater than or equal to 1.");
    }
    
    this.accountHolder = accountHolder;
    return this;
  }

   /**
   * The name of the [account holder](http://docs.griffin.com).
   * @return accountHolder
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the [account holder](http://docs.griffin.com).")

  public String getAccountHolder() {
    return accountHolder;
  }


  public void setAccountHolder(String accountHolder) {
    
    
    if (accountHolder != null && accountHolder.length() < 1) {
      throw new IllegalArgumentException("Invalid value for accountHolder. Length must be greater than or equal to 1.");
    }
    this.accountHolder = accountHolder;
  }


  public PayeeProperty4 accountNumber(String accountNumber) {
    
    
    if (accountNumber != null && accountNumber.length() < 8) {
      throw new IllegalArgumentException("Invalid value for accountNumber. Length must be greater than or equal to 8.");
    }
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * Must be a UK BBAN.
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "12345678", value = "Must be a UK BBAN.")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    if (accountNumber != null && accountNumber.length() < 8) {
      throw new IllegalArgumentException("Invalid value for accountNumber. Length must be greater than or equal to 8.");
    }
    this.accountNumber = accountNumber;
  }


  public PayeeProperty4 accountNumberCode(AccountNumberCodeEnum accountNumberCode) {
    
    
    
    
    this.accountNumberCode = accountNumberCode;
    return this;
  }

   /**
   * Get accountNumberCode
   * @return accountNumberCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public AccountNumberCodeEnum getAccountNumberCode() {
    return accountNumberCode;
  }


  public void setAccountNumberCode(AccountNumberCodeEnum accountNumberCode) {
    
    
    
    this.accountNumberCode = accountNumberCode;
  }


  public PayeeProperty4 bankId(String bankId) {
    
    
    if (bankId != null && bankId.length() < 6) {
      throw new IllegalArgumentException("Invalid value for bankId. Length must be greater than or equal to 6.");
    }
    
    this.bankId = bankId;
    return this;
  }

   /**
   * Must be a UK Sort Code.
   * @return bankId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "123456", value = "Must be a UK Sort Code.")

  public String getBankId() {
    return bankId;
  }


  public void setBankId(String bankId) {
    
    
    if (bankId != null && bankId.length() < 6) {
      throw new IllegalArgumentException("Invalid value for bankId. Length must be greater than or equal to 6.");
    }
    this.bankId = bankId;
  }


  public PayeeProperty4 bankIdCode(BankIdCodeEnum bankIdCode) {
    
    
    
    
    this.bankIdCode = bankIdCode;
    return this;
  }

   /**
   * Get bankIdCode
   * @return bankIdCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BankIdCodeEnum getBankIdCode() {
    return bankIdCode;
  }


  public void setBankIdCode(BankIdCodeEnum bankIdCode) {
    
    
    
    this.bankIdCode = bankIdCode;
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
   * @return the PayeeProperty4 instance itself
   */
  public PayeeProperty4 putAdditionalProperty(String key, Object value) {
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
    PayeeProperty4 payeeProperty4 = (PayeeProperty4) o;
    return Objects.equals(this.payeeUrl, payeeProperty4.payeeUrl) &&
        Objects.equals(this.creditorType, payeeProperty4.creditorType) &&
        Objects.equals(this.accountUrl, payeeProperty4.accountUrl) &&
        Objects.equals(this.accountHolder, payeeProperty4.accountHolder) &&
        Objects.equals(this.accountNumber, payeeProperty4.accountNumber) &&
        Objects.equals(this.accountNumberCode, payeeProperty4.accountNumberCode) &&
        Objects.equals(this.bankId, payeeProperty4.bankId) &&
        Objects.equals(this.bankIdCode, payeeProperty4.bankIdCode)&&
        Objects.equals(this.additionalProperties, payeeProperty4.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payeeUrl, creditorType, accountUrl, accountHolder, accountNumber, accountNumberCode, bankId, bankIdCode, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayeeProperty4 {\n");
    sb.append("    payeeUrl: ").append(toIndentedString(payeeUrl)).append("\n");
    sb.append("    creditorType: ").append(toIndentedString(creditorType)).append("\n");
    sb.append("    accountUrl: ").append(toIndentedString(accountUrl)).append("\n");
    sb.append("    accountHolder: ").append(toIndentedString(accountHolder)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountNumberCode: ").append(toIndentedString(accountNumberCode)).append("\n");
    sb.append("    bankId: ").append(toIndentedString(bankId)).append("\n");
    sb.append("    bankIdCode: ").append(toIndentedString(bankIdCode)).append("\n");
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
    openapiFields.add("payee-url");
    openapiFields.add("creditor-type");
    openapiFields.add("account-url");
    openapiFields.add("account-holder");
    openapiFields.add("account-number");
    openapiFields.add("account-number-code");
    openapiFields.add("bank-id");
    openapiFields.add("bank-id-code");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("creditor-type");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PayeeProperty4
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PayeeProperty4.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PayeeProperty4 is not found in the empty JSON string", PayeeProperty4.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PayeeProperty4.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("payee-url") != null && !jsonObj.get("payee-url").isJsonNull()) && !jsonObj.get("payee-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payee-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payee-url").toString()));
      }
      if (!jsonObj.get("creditor-type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditor-type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditor-type").toString()));
      }
      if ((jsonObj.get("account-url") != null && !jsonObj.get("account-url").isJsonNull()) && !jsonObj.get("account-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-url").toString()));
      }
      if ((jsonObj.get("account-holder") != null && !jsonObj.get("account-holder").isJsonNull()) && !jsonObj.get("account-holder").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-holder` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-holder").toString()));
      }
      if ((jsonObj.get("account-number") != null && !jsonObj.get("account-number").isJsonNull()) && !jsonObj.get("account-number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-number").toString()));
      }
      if ((jsonObj.get("account-number-code") != null && !jsonObj.get("account-number-code").isJsonNull()) && !jsonObj.get("account-number-code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-number-code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-number-code").toString()));
      }
      if ((jsonObj.get("bank-id") != null && !jsonObj.get("bank-id").isJsonNull()) && !jsonObj.get("bank-id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bank-id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bank-id").toString()));
      }
      if ((jsonObj.get("bank-id-code") != null && !jsonObj.get("bank-id-code").isJsonNull()) && !jsonObj.get("bank-id-code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bank-id-code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bank-id-code").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PayeeProperty4.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PayeeProperty4' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PayeeProperty4> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PayeeProperty4.class));

       return (TypeAdapter<T>) new TypeAdapter<PayeeProperty4>() {
           @Override
           public void write(JsonWriter out, PayeeProperty4 value) throws IOException {
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
           public PayeeProperty4 read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PayeeProperty4 instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PayeeProperty4 given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PayeeProperty4
  * @throws IOException if the JSON string is invalid with respect to PayeeProperty4
  */
  public static PayeeProperty4 fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PayeeProperty4.class);
  }

 /**
  * Convert an instance of PayeeProperty4 to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

