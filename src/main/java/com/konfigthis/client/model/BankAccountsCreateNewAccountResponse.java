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
import com.konfigthis.client.model.AccountBalanceProperty6;
import com.konfigthis.client.model.AvailableBalanceProperty4;
import com.konfigthis.client.model.BankAddress4;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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
 * BankAccountsCreateNewAccountResponse
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class BankAccountsCreateNewAccountResponse {
  public static final String SERIALIZED_NAME_ACCOUNT_SUBMISSIONS_URL = "account-submissions-url";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_SUBMISSIONS_URL)
  private String accountSubmissionsUrl;

  public static final String SERIALIZED_NAME_ACCOUNT_RESTRICTED = "account-restricted";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_RESTRICTED)
  private Boolean accountRestricted;

  public static final String SERIALIZED_NAME_ACCOUNT_PAYMENTS_URL = "account-payments-url";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_PAYMENTS_URL)
  private String accountPaymentsUrl;

  public static final String SERIALIZED_NAME_POOLED_ACCOUNT_MEMBERSHIPS_URL = "pooled-account-memberships-url";
  @SerializedName(SERIALIZED_NAME_POOLED_ACCOUNT_MEMBERSHIPS_URL)
  private String pooledAccountMembershipsUrl;

  public static final String SERIALIZED_NAME_ACCOUNT_ADMISSIONS_URL = "account-admissions-url";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ADMISSIONS_URL)
  private String accountAdmissionsUrl;

  /**
   * Specifies the type of bank account. (For more detail on bank account types, see our guide for [creating a bank account](http://docs.griffin.com).)
   */
  @JsonAdapter(BankProductTypeEnum.Adapter.class)
 public enum BankProductTypeEnum {
    SAVINGS_ACCOUNT("savings-account"),
    
    CLIENT_MONEY_ACCOUNT("client-money-account"),
    
    SAFEGUARDING_ACCOUNT("safeguarding-account"),
    
    OPERATIONAL_ACCOUNT("operational-account");

    private String value;

    BankProductTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BankProductTypeEnum fromValue(String value) {
      for (BankProductTypeEnum b : BankProductTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BankProductTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BankProductTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BankProductTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BankProductTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BANK_PRODUCT_TYPE = "bank-product-type";
  @SerializedName(SERIALIZED_NAME_BANK_PRODUCT_TYPE)
  private BankProductTypeEnum bankProductType;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display-name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_CONTROLLER_URL = "controller-url";
  @SerializedName(SERIALIZED_NAME_CONTROLLER_URL)
  private String controllerUrl;

  public static final String SERIALIZED_NAME_POOLED_FUNDS = "pooled-funds";
  @SerializedName(SERIALIZED_NAME_POOLED_FUNDS)
  private Boolean pooledFunds;

  /**
   * Shows the status of the account. An account can be moved between statuses during its lifecycle. The status value affects the operations that you can perform. An account must be &#x60;\&quot;open\&quot;&#x60; to be fully operational.
   */
  @JsonAdapter(AccountStatusEnum.Adapter.class)
 public enum AccountStatusEnum {
    CLOSING("closing"),
    
    OPEN("open"),
    
    CLOSED("closed"),
    
    OPENING("opening");

    private String value;

    AccountStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static AccountStatusEnum fromValue(String value) {
      for (AccountStatusEnum b : AccountStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<AccountStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AccountStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public AccountStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return AccountStatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ACCOUNT_STATUS = "account-status";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_STATUS)
  private AccountStatusEnum accountStatus;

  /**
   * Specifies the type of client money account.
   */
  @JsonAdapter(ClientMoneyTypeEnum.Adapter.class)
 public enum ClientMoneyTypeEnum {
    DESIGNATED_CLIENT_FUND("designated-client-fund"),
    
    DESIGNATED_CLIENT_MONEY("designated-client-money"),
    
    GENERAL_CLIENT_MONEY("general-client-money");

    private String value;

    ClientMoneyTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ClientMoneyTypeEnum fromValue(String value) {
      for (ClientMoneyTypeEnum b : ClientMoneyTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ClientMoneyTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ClientMoneyTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ClientMoneyTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ClientMoneyTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CLIENT_MONEY_TYPE = "client-money-type";
  @SerializedName(SERIALIZED_NAME_CLIENT_MONEY_TYPE)
  private ClientMoneyTypeEnum clientMoneyType;

  public static final String SERIALIZED_NAME_OWNER_URL = "owner-url";
  @SerializedName(SERIALIZED_NAME_OWNER_URL)
  private String ownerUrl;

  public static final String SERIALIZED_NAME_CREATED_AT = "created-at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private OffsetDateTime createdAt;

  public static final String SERIALIZED_NAME_CLOSE_ACCOUNT_URL = "close-account-url";
  @SerializedName(SERIALIZED_NAME_CLOSE_ACCOUNT_URL)
  private String closeAccountUrl;

  public static final String SERIALIZED_NAME_AVAILABLE_BALANCE = "available-balance";
  @SerializedName(SERIALIZED_NAME_AVAILABLE_BALANCE)
  private AvailableBalanceProperty4 availableBalance;

  public static final String SERIALIZED_NAME_POOLED_ACCOUNT_MEMBERSHIP_UPDATES_URL = "pooled-account-membership-updates-url";
  @SerializedName(SERIALIZED_NAME_POOLED_ACCOUNT_MEMBERSHIP_UPDATES_URL)
  private String pooledAccountMembershipUpdatesUrl;

  public static final String SERIALIZED_NAME_BANK_ADDRESSES = "bank-addresses";
  @SerializedName(SERIALIZED_NAME_BANK_ADDRESSES)
  private List<BankAddress4> bankAddresses = null;

  public static final String SERIALIZED_NAME_ACCOUNT_TRANSACTIONS_URL = "account-transactions-url";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_TRANSACTIONS_URL)
  private String accountTransactionsUrl;

  public static final String SERIALIZED_NAME_ACCOUNT_URL = "account-url";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_URL)
  private String accountUrl;

  public static final String SERIALIZED_NAME_BENEFICIARY_URL = "beneficiary-url";
  @SerializedName(SERIALIZED_NAME_BENEFICIARY_URL)
  private String beneficiaryUrl;

  public static final String SERIALIZED_NAME_ACCOUNT_BALANCE = "account-balance";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_BALANCE)
  private AccountBalanceProperty6 accountBalance;

  /**
   * Specifies the type of savings account.
   */
  @JsonAdapter(SavingsTypeEnum.Adapter.class)
 public enum SavingsTypeEnum {
    EASY_ACCESS("easy-access");

    private String value;

    SavingsTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SavingsTypeEnum fromValue(String value) {
      for (SavingsTypeEnum b : SavingsTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SavingsTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SavingsTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SavingsTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SavingsTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SAVINGS_TYPE = "savings-type";
  @SerializedName(SERIALIZED_NAME_SAVINGS_TYPE)
  private SavingsTypeEnum savingsType;

  public BankAccountsCreateNewAccountResponse() {
  }

  public BankAccountsCreateNewAccountResponse accountSubmissionsUrl(String accountSubmissionsUrl) {
    
    
    
    
    this.accountSubmissionsUrl = accountSubmissionsUrl;
    return this;
  }

   /**
   * Link to the [payment submissions](http://docs.griffin.com) debiting from this account.
   * @return accountSubmissionsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/bank/accounts/ba.IGJhbmstYWNjb3VudC1pZA/submissions", required = true, value = "Link to the [payment submissions](http://docs.griffin.com) debiting from this account.")

  public String getAccountSubmissionsUrl() {
    return accountSubmissionsUrl;
  }


  public void setAccountSubmissionsUrl(String accountSubmissionsUrl) {
    
    
    
    this.accountSubmissionsUrl = accountSubmissionsUrl;
  }


  public BankAccountsCreateNewAccountResponse accountRestricted(Boolean accountRestricted) {
    
    
    
    
    this.accountRestricted = accountRestricted;
    return this;
  }

   /**
   * Specifies whether the bank account has restrictions applied by Griffin.
   * @return accountRestricted
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specifies whether the bank account has restrictions applied by Griffin.")

  public Boolean getAccountRestricted() {
    return accountRestricted;
  }


  public void setAccountRestricted(Boolean accountRestricted) {
    
    
    
    this.accountRestricted = accountRestricted;
  }


  public BankAccountsCreateNewAccountResponse accountPaymentsUrl(String accountPaymentsUrl) {
    
    
    
    
    this.accountPaymentsUrl = accountPaymentsUrl;
    return this;
  }

   /**
   * Link to the [payments](http://docs.griffin.com) associated with this account.
   * @return accountPaymentsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/bank/accounts/ba.IGJhbmstYWNjb3VudC1pZA/payments", required = true, value = "Link to the [payments](http://docs.griffin.com) associated with this account.")

  public String getAccountPaymentsUrl() {
    return accountPaymentsUrl;
  }


  public void setAccountPaymentsUrl(String accountPaymentsUrl) {
    
    
    
    this.accountPaymentsUrl = accountPaymentsUrl;
  }


  public BankAccountsCreateNewAccountResponse pooledAccountMembershipsUrl(String pooledAccountMembershipsUrl) {
    
    
    
    
    this.pooledAccountMembershipsUrl = pooledAccountMembershipsUrl;
    return this;
  }

   /**
   * Link to the list of [pool members](http://docs.griffin.com) associated with this account.
   * @return pooledAccountMembershipsUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/bank/accounts/ba.IGJhbmstYWNjb3VudC1pZA/membership", value = "Link to the list of [pool members](http://docs.griffin.com) associated with this account.")

  public String getPooledAccountMembershipsUrl() {
    return pooledAccountMembershipsUrl;
  }


  public void setPooledAccountMembershipsUrl(String pooledAccountMembershipsUrl) {
    
    
    
    this.pooledAccountMembershipsUrl = pooledAccountMembershipsUrl;
  }


  public BankAccountsCreateNewAccountResponse accountAdmissionsUrl(String accountAdmissionsUrl) {
    
    
    
    
    this.accountAdmissionsUrl = accountAdmissionsUrl;
    return this;
  }

   /**
   * Link to the [payment admissions](http://docs.griffin.com) crediting to this account.
   * @return accountAdmissionsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/bank/accounts/ba.IGJhbmstYWNjb3VudC1pZA/admissions", required = true, value = "Link to the [payment admissions](http://docs.griffin.com) crediting to this account.")

  public String getAccountAdmissionsUrl() {
    return accountAdmissionsUrl;
  }


  public void setAccountAdmissionsUrl(String accountAdmissionsUrl) {
    
    
    
    this.accountAdmissionsUrl = accountAdmissionsUrl;
  }


  public BankAccountsCreateNewAccountResponse bankProductType(BankProductTypeEnum bankProductType) {
    
    
    
    
    this.bankProductType = bankProductType;
    return this;
  }

   /**
   * Specifies the type of bank account. (For more detail on bank account types, see our guide for [creating a bank account](http://docs.griffin.com).)
   * @return bankProductType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specifies the type of bank account. (For more detail on bank account types, see our guide for [creating a bank account](http://docs.griffin.com).)")

  public BankProductTypeEnum getBankProductType() {
    return bankProductType;
  }


  public void setBankProductType(BankProductTypeEnum bankProductType) {
    
    
    
    this.bankProductType = bankProductType;
  }


  public BankAccountsCreateNewAccountResponse displayName(String displayName) {
    
    
    if (displayName != null && displayName.length() < 1) {
      throw new IllegalArgumentException("Invalid value for displayName. Length must be greater than or equal to 1.");
    }
    
    this.displayName = displayName;
    return this;
  }

   /**
   * The mutable display name for the bank account
   * @return displayName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Reserve a/c", required = true, value = "The mutable display name for the bank account")

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    
    
    if (displayName != null && displayName.length() < 1) {
      throw new IllegalArgumentException("Invalid value for displayName. Length must be greater than or equal to 1.");
    }
    this.displayName = displayName;
  }


  public BankAccountsCreateNewAccountResponse controllerUrl(String controllerUrl) {
    
    
    
    
    this.controllerUrl = controllerUrl;
    return this;
  }

   /**
   * Link to the [legal person](http://docs.griffin.com) that represents the [controller](http://docs.griffin.com) of the account.
   * @return controllerUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA", required = true, value = "Link to the [legal person](http://docs.griffin.com) that represents the [controller](http://docs.griffin.com) of the account.")

  public String getControllerUrl() {
    return controllerUrl;
  }


  public void setControllerUrl(String controllerUrl) {
    
    
    
    this.controllerUrl = controllerUrl;
  }


  public BankAccountsCreateNewAccountResponse pooledFunds(Boolean pooledFunds) {
    
    
    
    
    this.pooledFunds = pooledFunds;
    return this;
  }

   /**
   * Specifies whether the bank account holds funds belonging to multiple beneficiaries.
   * @return pooledFunds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specifies whether the bank account holds funds belonging to multiple beneficiaries.")

  public Boolean getPooledFunds() {
    return pooledFunds;
  }


  public void setPooledFunds(Boolean pooledFunds) {
    
    
    
    this.pooledFunds = pooledFunds;
  }


  public BankAccountsCreateNewAccountResponse accountStatus(AccountStatusEnum accountStatus) {
    
    
    
    
    this.accountStatus = accountStatus;
    return this;
  }

   /**
   * Shows the status of the account. An account can be moved between statuses during its lifecycle. The status value affects the operations that you can perform. An account must be &#x60;\&quot;open\&quot;&#x60; to be fully operational.
   * @return accountStatus
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Shows the status of the account. An account can be moved between statuses during its lifecycle. The status value affects the operations that you can perform. An account must be `\"open\"` to be fully operational.")

  public AccountStatusEnum getAccountStatus() {
    return accountStatus;
  }


  public void setAccountStatus(AccountStatusEnum accountStatus) {
    
    
    
    this.accountStatus = accountStatus;
  }


  public BankAccountsCreateNewAccountResponse clientMoneyType(ClientMoneyTypeEnum clientMoneyType) {
    
    
    
    
    this.clientMoneyType = clientMoneyType;
    return this;
  }

   /**
   * Specifies the type of client money account.
   * @return clientMoneyType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of client money account.")

  public ClientMoneyTypeEnum getClientMoneyType() {
    return clientMoneyType;
  }


  public void setClientMoneyType(ClientMoneyTypeEnum clientMoneyType) {
    
    
    
    this.clientMoneyType = clientMoneyType;
  }


  public BankAccountsCreateNewAccountResponse ownerUrl(String ownerUrl) {
    
    
    
    
    this.ownerUrl = ownerUrl;
    return this;
  }

   /**
   * Link to the [legal person](http://docs.griffin.com) that represents the [owner](http://docs.griffin.com) of the account.
   * @return ownerUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA", required = true, value = "Link to the [legal person](http://docs.griffin.com) that represents the [owner](http://docs.griffin.com) of the account.")

  public String getOwnerUrl() {
    return ownerUrl;
  }


  public void setOwnerUrl(String ownerUrl) {
    
    
    
    this.ownerUrl = ownerUrl;
  }


  public BankAccountsCreateNewAccountResponse createdAt(OffsetDateTime createdAt) {
    
    
    
    
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


  public BankAccountsCreateNewAccountResponse closeAccountUrl(String closeAccountUrl) {
    
    
    
    
    this.closeAccountUrl = closeAccountUrl;
    return this;
  }

   /**
   * Link to the endpoint that enables account closure for this account.
   * @return closeAccountUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/bank/accounts/ba.IGJhbmstYWNjb3VudC1pZA/actions/close", required = true, value = "Link to the endpoint that enables account closure for this account.")

  public String getCloseAccountUrl() {
    return closeAccountUrl;
  }


  public void setCloseAccountUrl(String closeAccountUrl) {
    
    
    
    this.closeAccountUrl = closeAccountUrl;
  }


  public BankAccountsCreateNewAccountResponse availableBalance(AvailableBalanceProperty4 availableBalance) {
    
    
    
    
    this.availableBalance = availableBalance;
    return this;
  }

   /**
   * Get availableBalance
   * @return availableBalance
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public AvailableBalanceProperty4 getAvailableBalance() {
    return availableBalance;
  }


  public void setAvailableBalance(AvailableBalanceProperty4 availableBalance) {
    
    
    
    this.availableBalance = availableBalance;
  }


  public BankAccountsCreateNewAccountResponse pooledAccountMembershipUpdatesUrl(String pooledAccountMembershipUpdatesUrl) {
    
    
    
    
    this.pooledAccountMembershipUpdatesUrl = pooledAccountMembershipUpdatesUrl;
    return this;
  }

   /**
   * Link to manage [pooled account membership](http://docs.griffin.com).
   * @return pooledAccountMembershipUpdatesUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/bank/accounts/ba.IGJhbmstYWNjb3VudC1pZA/membership-updates", value = "Link to manage [pooled account membership](http://docs.griffin.com).")

  public String getPooledAccountMembershipUpdatesUrl() {
    return pooledAccountMembershipUpdatesUrl;
  }


  public void setPooledAccountMembershipUpdatesUrl(String pooledAccountMembershipUpdatesUrl) {
    
    
    
    this.pooledAccountMembershipUpdatesUrl = pooledAccountMembershipUpdatesUrl;
  }


  public BankAccountsCreateNewAccountResponse bankAddresses(List<BankAddress4> bankAddresses) {
    
    
    
    
    this.bankAddresses = bankAddresses;
    return this;
  }

  public BankAccountsCreateNewAccountResponse addBankAddressesItem(BankAddress4 bankAddressesItem) {
    if (this.bankAddresses == null) {
      this.bankAddresses = new ArrayList<>();
    }
    this.bankAddresses.add(bankAddressesItem);
    return this;
  }

   /**
   * Shows a collection of public addresses which uniquely identify the account. Any one of these can be used to pay into the account.
   * @return bankAddresses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Shows a collection of public addresses which uniquely identify the account. Any one of these can be used to pay into the account.")

  public List<BankAddress4> getBankAddresses() {
    return bankAddresses;
  }


  public void setBankAddresses(List<BankAddress4> bankAddresses) {
    
    
    
    this.bankAddresses = bankAddresses;
  }


  public BankAccountsCreateNewAccountResponse accountTransactionsUrl(String accountTransactionsUrl) {
    
    
    
    
    this.accountTransactionsUrl = accountTransactionsUrl;
    return this;
  }

   /**
   * Link to the [transactions](http://docs.griffin.com) associated with this account.
   * @return accountTransactionsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/bank/accounts/ba.IGJhbmstYWNjb3VudC1pZA/transactions", required = true, value = "Link to the [transactions](http://docs.griffin.com) associated with this account.")

  public String getAccountTransactionsUrl() {
    return accountTransactionsUrl;
  }


  public void setAccountTransactionsUrl(String accountTransactionsUrl) {
    
    
    
    this.accountTransactionsUrl = accountTransactionsUrl;
  }


  public BankAccountsCreateNewAccountResponse accountUrl(String accountUrl) {
    
    
    
    
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


  public BankAccountsCreateNewAccountResponse beneficiaryUrl(String beneficiaryUrl) {
    
    
    
    
    this.beneficiaryUrl = beneficiaryUrl;
    return this;
  }

   /**
   * Link to the [legal person](http://docs.griffin.com) that represents the [beneficiary](http://docs.griffin.com) of the account.
   * @return beneficiaryUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA", value = "Link to the [legal person](http://docs.griffin.com) that represents the [beneficiary](http://docs.griffin.com) of the account.")

  public String getBeneficiaryUrl() {
    return beneficiaryUrl;
  }


  public void setBeneficiaryUrl(String beneficiaryUrl) {
    
    
    
    this.beneficiaryUrl = beneficiaryUrl;
  }


  public BankAccountsCreateNewAccountResponse accountBalance(AccountBalanceProperty6 accountBalance) {
    
    
    
    
    this.accountBalance = accountBalance;
    return this;
  }

   /**
   * Get accountBalance
   * @return accountBalance
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public AccountBalanceProperty6 getAccountBalance() {
    return accountBalance;
  }


  public void setAccountBalance(AccountBalanceProperty6 accountBalance) {
    
    
    
    this.accountBalance = accountBalance;
  }


  public BankAccountsCreateNewAccountResponse savingsType(SavingsTypeEnum savingsType) {
    
    
    
    
    this.savingsType = savingsType;
    return this;
  }

   /**
   * Specifies the type of savings account.
   * @return savingsType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of savings account.")

  public SavingsTypeEnum getSavingsType() {
    return savingsType;
  }


  public void setSavingsType(SavingsTypeEnum savingsType) {
    
    
    
    this.savingsType = savingsType;
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
   * @return the BankAccountsCreateNewAccountResponse instance itself
   */
  public BankAccountsCreateNewAccountResponse putAdditionalProperty(String key, Object value) {
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
    BankAccountsCreateNewAccountResponse bankAccountsCreateNewAccountResponse = (BankAccountsCreateNewAccountResponse) o;
    return Objects.equals(this.accountSubmissionsUrl, bankAccountsCreateNewAccountResponse.accountSubmissionsUrl) &&
        Objects.equals(this.accountRestricted, bankAccountsCreateNewAccountResponse.accountRestricted) &&
        Objects.equals(this.accountPaymentsUrl, bankAccountsCreateNewAccountResponse.accountPaymentsUrl) &&
        Objects.equals(this.pooledAccountMembershipsUrl, bankAccountsCreateNewAccountResponse.pooledAccountMembershipsUrl) &&
        Objects.equals(this.accountAdmissionsUrl, bankAccountsCreateNewAccountResponse.accountAdmissionsUrl) &&
        Objects.equals(this.bankProductType, bankAccountsCreateNewAccountResponse.bankProductType) &&
        Objects.equals(this.displayName, bankAccountsCreateNewAccountResponse.displayName) &&
        Objects.equals(this.controllerUrl, bankAccountsCreateNewAccountResponse.controllerUrl) &&
        Objects.equals(this.pooledFunds, bankAccountsCreateNewAccountResponse.pooledFunds) &&
        Objects.equals(this.accountStatus, bankAccountsCreateNewAccountResponse.accountStatus) &&
        Objects.equals(this.clientMoneyType, bankAccountsCreateNewAccountResponse.clientMoneyType) &&
        Objects.equals(this.ownerUrl, bankAccountsCreateNewAccountResponse.ownerUrl) &&
        Objects.equals(this.createdAt, bankAccountsCreateNewAccountResponse.createdAt) &&
        Objects.equals(this.closeAccountUrl, bankAccountsCreateNewAccountResponse.closeAccountUrl) &&
        Objects.equals(this.availableBalance, bankAccountsCreateNewAccountResponse.availableBalance) &&
        Objects.equals(this.pooledAccountMembershipUpdatesUrl, bankAccountsCreateNewAccountResponse.pooledAccountMembershipUpdatesUrl) &&
        Objects.equals(this.bankAddresses, bankAccountsCreateNewAccountResponse.bankAddresses) &&
        Objects.equals(this.accountTransactionsUrl, bankAccountsCreateNewAccountResponse.accountTransactionsUrl) &&
        Objects.equals(this.accountUrl, bankAccountsCreateNewAccountResponse.accountUrl) &&
        Objects.equals(this.beneficiaryUrl, bankAccountsCreateNewAccountResponse.beneficiaryUrl) &&
        Objects.equals(this.accountBalance, bankAccountsCreateNewAccountResponse.accountBalance) &&
        Objects.equals(this.savingsType, bankAccountsCreateNewAccountResponse.savingsType)&&
        Objects.equals(this.additionalProperties, bankAccountsCreateNewAccountResponse.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountSubmissionsUrl, accountRestricted, accountPaymentsUrl, pooledAccountMembershipsUrl, accountAdmissionsUrl, bankProductType, displayName, controllerUrl, pooledFunds, accountStatus, clientMoneyType, ownerUrl, createdAt, closeAccountUrl, availableBalance, pooledAccountMembershipUpdatesUrl, bankAddresses, accountTransactionsUrl, accountUrl, beneficiaryUrl, accountBalance, savingsType, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankAccountsCreateNewAccountResponse {\n");
    sb.append("    accountSubmissionsUrl: ").append(toIndentedString(accountSubmissionsUrl)).append("\n");
    sb.append("    accountRestricted: ").append(toIndentedString(accountRestricted)).append("\n");
    sb.append("    accountPaymentsUrl: ").append(toIndentedString(accountPaymentsUrl)).append("\n");
    sb.append("    pooledAccountMembershipsUrl: ").append(toIndentedString(pooledAccountMembershipsUrl)).append("\n");
    sb.append("    accountAdmissionsUrl: ").append(toIndentedString(accountAdmissionsUrl)).append("\n");
    sb.append("    bankProductType: ").append(toIndentedString(bankProductType)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    controllerUrl: ").append(toIndentedString(controllerUrl)).append("\n");
    sb.append("    pooledFunds: ").append(toIndentedString(pooledFunds)).append("\n");
    sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
    sb.append("    clientMoneyType: ").append(toIndentedString(clientMoneyType)).append("\n");
    sb.append("    ownerUrl: ").append(toIndentedString(ownerUrl)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    closeAccountUrl: ").append(toIndentedString(closeAccountUrl)).append("\n");
    sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
    sb.append("    pooledAccountMembershipUpdatesUrl: ").append(toIndentedString(pooledAccountMembershipUpdatesUrl)).append("\n");
    sb.append("    bankAddresses: ").append(toIndentedString(bankAddresses)).append("\n");
    sb.append("    accountTransactionsUrl: ").append(toIndentedString(accountTransactionsUrl)).append("\n");
    sb.append("    accountUrl: ").append(toIndentedString(accountUrl)).append("\n");
    sb.append("    beneficiaryUrl: ").append(toIndentedString(beneficiaryUrl)).append("\n");
    sb.append("    accountBalance: ").append(toIndentedString(accountBalance)).append("\n");
    sb.append("    savingsType: ").append(toIndentedString(savingsType)).append("\n");
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
    openapiFields.add("account-submissions-url");
    openapiFields.add("account-restricted");
    openapiFields.add("account-payments-url");
    openapiFields.add("pooled-account-memberships-url");
    openapiFields.add("account-admissions-url");
    openapiFields.add("bank-product-type");
    openapiFields.add("display-name");
    openapiFields.add("controller-url");
    openapiFields.add("pooled-funds");
    openapiFields.add("account-status");
    openapiFields.add("client-money-type");
    openapiFields.add("owner-url");
    openapiFields.add("created-at");
    openapiFields.add("close-account-url");
    openapiFields.add("available-balance");
    openapiFields.add("pooled-account-membership-updates-url");
    openapiFields.add("bank-addresses");
    openapiFields.add("account-transactions-url");
    openapiFields.add("account-url");
    openapiFields.add("beneficiary-url");
    openapiFields.add("account-balance");
    openapiFields.add("savings-type");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("account-submissions-url");
    openapiRequiredFields.add("account-restricted");
    openapiRequiredFields.add("account-payments-url");
    openapiRequiredFields.add("account-admissions-url");
    openapiRequiredFields.add("bank-product-type");
    openapiRequiredFields.add("display-name");
    openapiRequiredFields.add("controller-url");
    openapiRequiredFields.add("pooled-funds");
    openapiRequiredFields.add("account-status");
    openapiRequiredFields.add("owner-url");
    openapiRequiredFields.add("created-at");
    openapiRequiredFields.add("close-account-url");
    openapiRequiredFields.add("available-balance");
    openapiRequiredFields.add("account-transactions-url");
    openapiRequiredFields.add("account-url");
    openapiRequiredFields.add("account-balance");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to BankAccountsCreateNewAccountResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!BankAccountsCreateNewAccountResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in BankAccountsCreateNewAccountResponse is not found in the empty JSON string", BankAccountsCreateNewAccountResponse.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : BankAccountsCreateNewAccountResponse.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("account-submissions-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-submissions-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-submissions-url").toString()));
      }
      if (!jsonObj.get("account-payments-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-payments-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-payments-url").toString()));
      }
      if ((jsonObj.get("pooled-account-memberships-url") != null && !jsonObj.get("pooled-account-memberships-url").isJsonNull()) && !jsonObj.get("pooled-account-memberships-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pooled-account-memberships-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pooled-account-memberships-url").toString()));
      }
      if (!jsonObj.get("account-admissions-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-admissions-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-admissions-url").toString()));
      }
      if (!jsonObj.get("bank-product-type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bank-product-type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bank-product-type").toString()));
      }
      if (!jsonObj.get("display-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `display-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("display-name").toString()));
      }
      if (!jsonObj.get("controller-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `controller-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("controller-url").toString()));
      }
      if (!jsonObj.get("account-status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-status").toString()));
      }
      if ((jsonObj.get("client-money-type") != null && !jsonObj.get("client-money-type").isJsonNull()) && !jsonObj.get("client-money-type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `client-money-type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("client-money-type").toString()));
      }
      if (!jsonObj.get("owner-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `owner-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("owner-url").toString()));
      }
      if (!jsonObj.get("close-account-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `close-account-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("close-account-url").toString()));
      }
      // validate the required field `available-balance`
      AvailableBalanceProperty4.validateJsonObject(jsonObj.getAsJsonObject("available-balance"));
      if ((jsonObj.get("pooled-account-membership-updates-url") != null && !jsonObj.get("pooled-account-membership-updates-url").isJsonNull()) && !jsonObj.get("pooled-account-membership-updates-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pooled-account-membership-updates-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pooled-account-membership-updates-url").toString()));
      }
      if (jsonObj.get("bank-addresses") != null && !jsonObj.get("bank-addresses").isJsonNull()) {
        JsonArray jsonArraybankAddresses = jsonObj.getAsJsonArray("bank-addresses");
        if (jsonArraybankAddresses != null) {
          // ensure the json data is an array
          if (!jsonObj.get("bank-addresses").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `bank-addresses` to be an array in the JSON string but got `%s`", jsonObj.get("bank-addresses").toString()));
          }

          // validate the optional field `bank-addresses` (array)
          for (int i = 0; i < jsonArraybankAddresses.size(); i++) {
            BankAddress4.validateJsonObject(jsonArraybankAddresses.get(i).getAsJsonObject());
          };
        }
      }
      if (!jsonObj.get("account-transactions-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-transactions-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-transactions-url").toString()));
      }
      if (!jsonObj.get("account-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account-url").toString()));
      }
      if ((jsonObj.get("beneficiary-url") != null && !jsonObj.get("beneficiary-url").isJsonNull()) && !jsonObj.get("beneficiary-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `beneficiary-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("beneficiary-url").toString()));
      }
      // validate the required field `account-balance`
      AccountBalanceProperty6.validateJsonObject(jsonObj.getAsJsonObject("account-balance"));
      if ((jsonObj.get("savings-type") != null && !jsonObj.get("savings-type").isJsonNull()) && !jsonObj.get("savings-type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `savings-type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("savings-type").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!BankAccountsCreateNewAccountResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'BankAccountsCreateNewAccountResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<BankAccountsCreateNewAccountResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(BankAccountsCreateNewAccountResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<BankAccountsCreateNewAccountResponse>() {
           @Override
           public void write(JsonWriter out, BankAccountsCreateNewAccountResponse value) throws IOException {
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
           public BankAccountsCreateNewAccountResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             BankAccountsCreateNewAccountResponse instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of BankAccountsCreateNewAccountResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of BankAccountsCreateNewAccountResponse
  * @throws IOException if the JSON string is invalid with respect to BankAccountsCreateNewAccountResponse
  */
  public static BankAccountsCreateNewAccountResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, BankAccountsCreateNewAccountResponse.class);
  }

 /**
  * Convert an instance of BankAccountsCreateNewAccountResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

