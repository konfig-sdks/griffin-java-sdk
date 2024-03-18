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
 * PayeesGetDetailsResponse
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PayeesGetDetailsResponse {
  public static final String SERIALIZED_NAME_PAYEE_URL = "payee-url";
  @SerializedName(SERIALIZED_NAME_PAYEE_URL)
  private String payeeUrl;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "account-number";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_ACCOUNT_HOLDER = "account-holder";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_HOLDER)
  private String accountHolder;

  public static final String SERIALIZED_NAME_LEGAL_PERSON_URL = "legal-person-url";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_URL)
  private String legalPersonUrl;

  public static final String SERIALIZED_NAME_BANK_ID = "bank-id";
  @SerializedName(SERIALIZED_NAME_BANK_ID)
  private String bankId;

  public static final String SERIALIZED_NAME_CREATED_AT = "created-at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private OffsetDateTime createdAt;

  public static final String SERIALIZED_NAME_ACCOUNT_URL = "account-url";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_URL)
  private String accountUrl;

  /**
   * The status of the payee; you can only make payments to active payees.
   */
  @JsonAdapter(PayeeStatusEnum.Adapter.class)
 public enum PayeeStatusEnum {
    DEACTIVATED("deactivated"),
    
    ACTIVE("active");

    private String value;

    PayeeStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PayeeStatusEnum fromValue(String value) {
      for (PayeeStatusEnum b : PayeeStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PayeeStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PayeeStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PayeeStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PayeeStatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PAYEE_STATUS = "payee-status";
  @SerializedName(SERIALIZED_NAME_PAYEE_STATUS)
  private PayeeStatusEnum payeeStatus;

  public static final String SERIALIZED_NAME_COUNTRY_CODE = "country-code";
  @SerializedName(SERIALIZED_NAME_COUNTRY_CODE)
  private Object countryCode = null;

  public PayeesGetDetailsResponse() {
  }

  public PayeesGetDetailsResponse payeeUrl(String payeeUrl) {
    
    
    
    
    this.payeeUrl = payeeUrl;
    return this;
  }

   /**
   * Link to the [payee](http://docs.griffin.com).
   * @return payeeUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/payees/pe.ICAgICAgICBwYXllZS1pZA", required = true, value = "Link to the [payee](http://docs.griffin.com).")

  public String getPayeeUrl() {
    return payeeUrl;
  }


  public void setPayeeUrl(String payeeUrl) {
    
    
    
    this.payeeUrl = payeeUrl;
  }


  public PayeesGetDetailsResponse accountNumber(String accountNumber) {
    
    
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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "12345678", required = true, value = "Must be a UK BBAN.")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    if (accountNumber != null && accountNumber.length() < 8) {
      throw new IllegalArgumentException("Invalid value for accountNumber. Length must be greater than or equal to 8.");
    }
    this.accountNumber = accountNumber;
  }


  public PayeesGetDetailsResponse accountHolder(String accountHolder) {
    
    
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
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The name of the [account holder](http://docs.griffin.com).")

  public String getAccountHolder() {
    return accountHolder;
  }


  public void setAccountHolder(String accountHolder) {
    
    
    if (accountHolder != null && accountHolder.length() < 1) {
      throw new IllegalArgumentException("Invalid value for accountHolder. Length must be greater than or equal to 1.");
    }
    this.accountHolder = accountHolder;
  }


  public PayeesGetDetailsResponse legalPersonUrl(String legalPersonUrl) {
    
    
    
    
    this.legalPersonUrl = legalPersonUrl;
    return this;
  }

   /**
   * A contextual link to the [legal person](http://docs.griffin.com).
   * @return legalPersonUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA", required = true, value = "A contextual link to the [legal person](http://docs.griffin.com).")

  public String getLegalPersonUrl() {
    return legalPersonUrl;
  }


  public void setLegalPersonUrl(String legalPersonUrl) {
    
    
    
    this.legalPersonUrl = legalPersonUrl;
  }


  public PayeesGetDetailsResponse bankId(String bankId) {
    
    
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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "123456", required = true, value = "Must be a UK Sort Code.")

  public String getBankId() {
    return bankId;
  }


  public void setBankId(String bankId) {
    
    
    if (bankId != null && bankId.length() < 6) {
      throw new IllegalArgumentException("Invalid value for bankId. Length must be greater than or equal to 6.");
    }
    this.bankId = bankId;
  }


  public PayeesGetDetailsResponse createdAt(OffsetDateTime createdAt) {
    
    
    
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * ISO 8601 formatted date-time.
   * @return createdAt
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "ISO 8601 formatted date-time.")

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(OffsetDateTime createdAt) {
    
    
    
    this.createdAt = createdAt;
  }


  public PayeesGetDetailsResponse accountUrl(String accountUrl) {
    
    
    
    
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


  public PayeesGetDetailsResponse payeeStatus(PayeeStatusEnum payeeStatus) {
    
    
    
    
    this.payeeStatus = payeeStatus;
    return this;
  }

   /**
   * The status of the payee; you can only make payments to active payees.
   * @return payeeStatus
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The status of the payee; you can only make payments to active payees.")

  public PayeeStatusEnum getPayeeStatus() {
    return payeeStatus;
  }


  public void setPayeeStatus(PayeeStatusEnum payeeStatus) {
    
    
    
    this.payeeStatus = payeeStatus;
  }


  public PayeesGetDetailsResponse countryCode(Object countryCode) {
    
    
    if (countryCode != null && countryCode.length() < 2) {
      throw new IllegalArgumentException("Invalid value for countryCode. Length must be greater than or equal to 2.");
    }
    
    this.countryCode = countryCode;
    return this;
  }

   /**
   * ISO 3166-1 alpha-2 two-letter country code.
   * @return countryCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "GB", required = true, value = "ISO 3166-1 alpha-2 two-letter country code.")

  public Object getCountryCode() {
    return countryCode;
  }


  public void setCountryCode(Object countryCode) {
    
    
    if (countryCode != null && countryCode.length() < 2) {
      throw new IllegalArgumentException("Invalid value for countryCode. Length must be greater than or equal to 2.");
    }
    this.countryCode = countryCode;
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
   * @return the PayeesGetDetailsResponse instance itself
   */
  public PayeesGetDetailsResponse putAdditionalProperty(String key, Object value) {
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
    PayeesGetDetailsResponse payeesGetDetailsResponse = (PayeesGetDetailsResponse) o;
    return Objects.equals(this.payeeUrl, payeesGetDetailsResponse.payeeUrl) &&
        Objects.equals(this.accountNumber, payeesGetDetailsResponse.accountNumber) &&
        Objects.equals(this.accountHolder, payeesGetDetailsResponse.accountHolder) &&
        Objects.equals(this.legalPersonUrl, payeesGetDetailsResponse.legalPersonUrl) &&
        Objects.equals(this.bankId, payeesGetDetailsResponse.bankId) &&
        Objects.equals(this.createdAt, payeesGetDetailsResponse.createdAt) &&
        Objects.equals(this.accountUrl, payeesGetDetailsResponse.accountUrl) &&
        Objects.equals(this.payeeStatus, payeesGetDetailsResponse.payeeStatus) &&
        Objects.equals(this.countryCode, payeesGetDetailsResponse.countryCode)&&
        Objects.equals(this.additionalProperties, payeesGetDetailsResponse.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payeeUrl, accountNumber, accountHolder, legalPersonUrl, bankId, createdAt, accountUrl, payeeStatus, countryCode, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayeesGetDetailsResponse {\n");
    sb.append("    payeeUrl: ").append(toIndentedString(payeeUrl)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountHolder: ").append(toIndentedString(accountHolder)).append("\n");
    sb.append("    legalPersonUrl: ").append(toIndentedString(legalPersonUrl)).append("\n");
    sb.append("    bankId: ").append(toIndentedString(bankId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    accountUrl: ").append(toIndentedString(accountUrl)).append("\n");
    sb.append("    payeeStatus: ").append(toIndentedString(payeeStatus)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
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
    openapiFields.add("account-number");
    openapiFields.add("account-holder");
    openapiFields.add("legal-person-url");
    openapiFields.add("bank-id");
    openapiFields.add("created-at");
    openapiFields.add("account-url");
    openapiFields.add("payee-status");
    openapiFields.add("country-code");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("payee-url");
    openapiRequiredFields.add("account-number");
    openapiRequiredFields.add("account-holder");
    openapiRequiredFields.add("legal-person-url");
    openapiRequiredFields.add("bank-id");
    openapiRequiredFields.add("created-at");
    openapiRequiredFields.add("payee-status");
    openapiRequiredFields.add("country-code");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PayeesGetDetailsResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PayeesGetDetailsResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PayeesGetDetailsResponse is not found in the empty JSON string", PayeesGetDetailsResponse.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PayeesGetDetailsResponse.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("payee-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payee-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payee-url").toString()));
      }
      if (!jsonObj.get("account-number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-number").toString()));
      }
      if (!jsonObj.get("account-holder").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-holder` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-holder").toString()));
      }
      if (!jsonObj.get("legal-person-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-person-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legal-person-url").toString()));
      }
      if (!jsonObj.get("bank-id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bank-id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bank-id").toString()));
      }
      if ((jsonObj.get("account-url") != null && !jsonObj.get("account-url").isJsonNull()) && !jsonObj.get("account-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-url").toString()));
      }
      if (!jsonObj.get("payee-status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payee-status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payee-status").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PayeesGetDetailsResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PayeesGetDetailsResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PayeesGetDetailsResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PayeesGetDetailsResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<PayeesGetDetailsResponse>() {
           @Override
           public void write(JsonWriter out, PayeesGetDetailsResponse value) throws IOException {
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
           public PayeesGetDetailsResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PayeesGetDetailsResponse instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PayeesGetDetailsResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PayeesGetDetailsResponse
  * @throws IOException if the JSON string is invalid with respect to PayeesGetDetailsResponse
  */
  public static PayeesGetDetailsResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PayeesGetDetailsResponse.class);
  }

 /**
  * Convert an instance of PayeesGetDetailsResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

