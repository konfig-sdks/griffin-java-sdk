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
import com.konfigthis.client.model.DebtorProperty2;
import com.konfigthis.client.model.PayeeProperty3;
import com.konfigthis.client.model.PaymentAmountProperty3;
import com.konfigthis.client.model.UltimateDebtorProperty2;
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
 * Payment1
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class Payment1 {
  public static final String SERIALIZED_NAME_CREDITOR = "creditor";
  @SerializedName(SERIALIZED_NAME_CREDITOR)
  private PayeeProperty3 creditor;

  /**
   * Whether the payment is moving money into or out of the account.
   */
  @JsonAdapter(PaymentDirectionEnum.Adapter.class)
 public enum PaymentDirectionEnum {
    INBOUND_PAYMENT("inbound-payment"),
    
    OUTBOUND_PAYMENT("outbound-payment");

    private String value;

    PaymentDirectionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PaymentDirectionEnum fromValue(String value) {
      for (PaymentDirectionEnum b : PaymentDirectionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PaymentDirectionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PaymentDirectionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PaymentDirectionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PaymentDirectionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PAYMENT_DIRECTION = "payment-direction";
  @SerializedName(SERIALIZED_NAME_PAYMENT_DIRECTION)
  private PaymentDirectionEnum paymentDirection;

  public static final String SERIALIZED_NAME_CREATED_AT = "created-at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private OffsetDateTime createdAt;

  public static final String SERIALIZED_NAME_PAYMENT_URL = "payment-url";
  @SerializedName(SERIALIZED_NAME_PAYMENT_URL)
  private String paymentUrl;

  public static final String SERIALIZED_NAME_PAYMENT_REFERENCE = "payment-reference";
  @SerializedName(SERIALIZED_NAME_PAYMENT_REFERENCE)
  private String paymentReference;

  public static final String SERIALIZED_NAME_PAYMENT_AMOUNT = "payment-amount";
  @SerializedName(SERIALIZED_NAME_PAYMENT_AMOUNT)
  private PaymentAmountProperty3 paymentAmount;

  public static final String SERIALIZED_NAME_ULTIMATE_DEBTOR = "ultimate-debtor";
  @SerializedName(SERIALIZED_NAME_ULTIMATE_DEBTOR)
  private UltimateDebtorProperty2 ultimateDebtor;

  public static final String SERIALIZED_NAME_PAYMENT_ADMISSIONS_URL = "payment-admissions-url";
  @SerializedName(SERIALIZED_NAME_PAYMENT_ADMISSIONS_URL)
  private String paymentAdmissionsUrl;

  public static final String SERIALIZED_NAME_PAYMENT_SUBMISSIONS_URL = "payment-submissions-url";
  @SerializedName(SERIALIZED_NAME_PAYMENT_SUBMISSIONS_URL)
  private String paymentSubmissionsUrl;

  public static final String SERIALIZED_NAME_DEBTOR = "debtor";
  @SerializedName(SERIALIZED_NAME_DEBTOR)
  private DebtorProperty2 debtor;

  public Payment1() {
  }

  public Payment1 creditor(PayeeProperty3 creditor) {
    
    
    
    
    this.creditor = creditor;
    return this;
  }

   /**
   * Get creditor
   * @return creditor
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public PayeeProperty3 getCreditor() {
    return creditor;
  }


  public void setCreditor(PayeeProperty3 creditor) {
    
    
    
    this.creditor = creditor;
  }


  public Payment1 paymentDirection(PaymentDirectionEnum paymentDirection) {
    
    
    
    
    this.paymentDirection = paymentDirection;
    return this;
  }

   /**
   * Whether the payment is moving money into or out of the account.
   * @return paymentDirection
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Whether the payment is moving money into or out of the account.")

  public PaymentDirectionEnum getPaymentDirection() {
    return paymentDirection;
  }


  public void setPaymentDirection(PaymentDirectionEnum paymentDirection) {
    
    
    
    this.paymentDirection = paymentDirection;
  }


  public Payment1 createdAt(OffsetDateTime createdAt) {
    
    
    
    
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


  public Payment1 paymentUrl(String paymentUrl) {
    
    
    
    
    this.paymentUrl = paymentUrl;
    return this;
  }

   /**
   * Link to the payment resource.
   * @return paymentUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/payments/pm.ICAgICAgcGF5bWVudC1pZA", required = true, value = "Link to the payment resource.")

  public String getPaymentUrl() {
    return paymentUrl;
  }


  public void setPaymentUrl(String paymentUrl) {
    
    
    
    this.paymentUrl = paymentUrl;
  }


  public Payment1 paymentReference(String paymentReference) {
    
    
    if (paymentReference != null && paymentReference.length() < 1) {
      throw new IllegalArgumentException("Invalid value for paymentReference. Length must be greater than or equal to 1.");
    }
    
    this.paymentReference = paymentReference;
    return this;
  }

   /**
   * Free-text field to help identify and categorise payments.
   * @return paymentReference
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "test reference", value = "Free-text field to help identify and categorise payments.")

  public String getPaymentReference() {
    return paymentReference;
  }


  public void setPaymentReference(String paymentReference) {
    
    
    if (paymentReference != null && paymentReference.length() < 1) {
      throw new IllegalArgumentException("Invalid value for paymentReference. Length must be greater than or equal to 1.");
    }
    this.paymentReference = paymentReference;
  }


  public Payment1 paymentAmount(PaymentAmountProperty3 paymentAmount) {
    
    
    
    
    this.paymentAmount = paymentAmount;
    return this;
  }

   /**
   * Get paymentAmount
   * @return paymentAmount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public PaymentAmountProperty3 getPaymentAmount() {
    return paymentAmount;
  }


  public void setPaymentAmount(PaymentAmountProperty3 paymentAmount) {
    
    
    
    this.paymentAmount = paymentAmount;
  }


  public Payment1 ultimateDebtor(UltimateDebtorProperty2 ultimateDebtor) {
    
    
    
    
    this.ultimateDebtor = ultimateDebtor;
    return this;
  }

   /**
   * Get ultimateDebtor
   * @return ultimateDebtor
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public UltimateDebtorProperty2 getUltimateDebtor() {
    return ultimateDebtor;
  }


  public void setUltimateDebtor(UltimateDebtorProperty2 ultimateDebtor) {
    
    
    
    this.ultimateDebtor = ultimateDebtor;
  }


  public Payment1 paymentAdmissionsUrl(String paymentAdmissionsUrl) {
    
    
    
    
    this.paymentAdmissionsUrl = paymentAdmissionsUrl;
    return this;
  }

   /**
   * Link to the endpoint for listing payment admissions.
   * @return paymentAdmissionsUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/payments/pm.ICAgICAgcGF5bWVudC1pZA/admissions", value = "Link to the endpoint for listing payment admissions.")

  public String getPaymentAdmissionsUrl() {
    return paymentAdmissionsUrl;
  }


  public void setPaymentAdmissionsUrl(String paymentAdmissionsUrl) {
    
    
    
    this.paymentAdmissionsUrl = paymentAdmissionsUrl;
  }


  public Payment1 paymentSubmissionsUrl(String paymentSubmissionsUrl) {
    
    
    
    
    this.paymentSubmissionsUrl = paymentSubmissionsUrl;
    return this;
  }

   /**
   * Link to the endpoint for creating and listing payment submissions.
   * @return paymentSubmissionsUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/payments/pm.ICAgICAgcGF5bWVudC1pZA/submissions", value = "Link to the endpoint for creating and listing payment submissions.")

  public String getPaymentSubmissionsUrl() {
    return paymentSubmissionsUrl;
  }


  public void setPaymentSubmissionsUrl(String paymentSubmissionsUrl) {
    
    
    
    this.paymentSubmissionsUrl = paymentSubmissionsUrl;
  }


  public Payment1 debtor(DebtorProperty2 debtor) {
    
    
    
    
    this.debtor = debtor;
    return this;
  }

   /**
   * Get debtor
   * @return debtor
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public DebtorProperty2 getDebtor() {
    return debtor;
  }


  public void setDebtor(DebtorProperty2 debtor) {
    
    
    
    this.debtor = debtor;
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
   * @return the Payment1 instance itself
   */
  public Payment1 putAdditionalProperty(String key, Object value) {
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
    Payment1 payment1 = (Payment1) o;
    return Objects.equals(this.creditor, payment1.creditor) &&
        Objects.equals(this.paymentDirection, payment1.paymentDirection) &&
        Objects.equals(this.createdAt, payment1.createdAt) &&
        Objects.equals(this.paymentUrl, payment1.paymentUrl) &&
        Objects.equals(this.paymentReference, payment1.paymentReference) &&
        Objects.equals(this.paymentAmount, payment1.paymentAmount) &&
        Objects.equals(this.ultimateDebtor, payment1.ultimateDebtor) &&
        Objects.equals(this.paymentAdmissionsUrl, payment1.paymentAdmissionsUrl) &&
        Objects.equals(this.paymentSubmissionsUrl, payment1.paymentSubmissionsUrl) &&
        Objects.equals(this.debtor, payment1.debtor)&&
        Objects.equals(this.additionalProperties, payment1.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditor, paymentDirection, createdAt, paymentUrl, paymentReference, paymentAmount, ultimateDebtor, paymentAdmissionsUrl, paymentSubmissionsUrl, debtor, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment1 {\n");
    sb.append("    creditor: ").append(toIndentedString(creditor)).append("\n");
    sb.append("    paymentDirection: ").append(toIndentedString(paymentDirection)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    paymentUrl: ").append(toIndentedString(paymentUrl)).append("\n");
    sb.append("    paymentReference: ").append(toIndentedString(paymentReference)).append("\n");
    sb.append("    paymentAmount: ").append(toIndentedString(paymentAmount)).append("\n");
    sb.append("    ultimateDebtor: ").append(toIndentedString(ultimateDebtor)).append("\n");
    sb.append("    paymentAdmissionsUrl: ").append(toIndentedString(paymentAdmissionsUrl)).append("\n");
    sb.append("    paymentSubmissionsUrl: ").append(toIndentedString(paymentSubmissionsUrl)).append("\n");
    sb.append("    debtor: ").append(toIndentedString(debtor)).append("\n");
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
    openapiFields.add("creditor");
    openapiFields.add("payment-direction");
    openapiFields.add("created-at");
    openapiFields.add("payment-url");
    openapiFields.add("payment-reference");
    openapiFields.add("payment-amount");
    openapiFields.add("ultimate-debtor");
    openapiFields.add("payment-admissions-url");
    openapiFields.add("payment-submissions-url");
    openapiFields.add("debtor");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("creditor");
    openapiRequiredFields.add("payment-direction");
    openapiRequiredFields.add("created-at");
    openapiRequiredFields.add("payment-url");
    openapiRequiredFields.add("payment-amount");
    openapiRequiredFields.add("debtor");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Payment1
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!Payment1.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Payment1 is not found in the empty JSON string", Payment1.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Payment1.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // validate the required field `creditor`
      PayeeProperty3.validateJsonObject(jsonObj.getAsJsonObject("creditor"));
      if (!jsonObj.get("payment-direction").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payment-direction` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payment-direction").toString()));
      }
      if (!jsonObj.get("payment-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payment-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payment-url").toString()));
      }
      if ((jsonObj.get("payment-reference") != null && !jsonObj.get("payment-reference").isJsonNull()) && !jsonObj.get("payment-reference").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payment-reference` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payment-reference").toString()));
      }
      // validate the required field `payment-amount`
      PaymentAmountProperty3.validateJsonObject(jsonObj.getAsJsonObject("payment-amount"));
      // validate the optional field `ultimate-debtor`
      if (jsonObj.get("ultimate-debtor") != null && !jsonObj.get("ultimate-debtor").isJsonNull()) {
        UltimateDebtorProperty2.validateJsonObject(jsonObj.getAsJsonObject("ultimate-debtor"));
      }
      if ((jsonObj.get("payment-admissions-url") != null && !jsonObj.get("payment-admissions-url").isJsonNull()) && !jsonObj.get("payment-admissions-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payment-admissions-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payment-admissions-url").toString()));
      }
      if ((jsonObj.get("payment-submissions-url") != null && !jsonObj.get("payment-submissions-url").isJsonNull()) && !jsonObj.get("payment-submissions-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payment-submissions-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payment-submissions-url").toString()));
      }
      // validate the required field `debtor`
      DebtorProperty2.validateJsonObject(jsonObj.getAsJsonObject("debtor"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Payment1.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Payment1' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Payment1> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Payment1.class));

       return (TypeAdapter<T>) new TypeAdapter<Payment1>() {
           @Override
           public void write(JsonWriter out, Payment1 value) throws IOException {
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
           public Payment1 read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             Payment1 instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of Payment1 given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Payment1
  * @throws IOException if the JSON string is invalid with respect to Payment1
  */
  public static Payment1 fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Payment1.class);
  }

 /**
  * Convert an instance of Payment1 to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

