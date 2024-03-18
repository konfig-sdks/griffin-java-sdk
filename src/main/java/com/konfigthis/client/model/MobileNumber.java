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
import com.konfigthis.client.model.AnnualTurnoverProperty1;
import com.konfigthis.client.model.BothBuildingNameAndBuildingNumberProperty;
import com.konfigthis.client.model.IncomeProperty1;
import com.konfigthis.client.model.InitialDepositProperty1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openapitools.jackson.nullable.JsonNullable;

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
 * MobileNumber
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class MobileNumber {
  public static final String SERIALIZED_NAME_MOBILE_NUMBER = "mobile-number";
  @SerializedName(SERIALIZED_NAME_MOBILE_NUMBER)
  private Object mobileNumber = null;

  /**
   * Gets or Sets claimType
   */
  @JsonAdapter(ClaimTypeEnum.Adapter.class)
 public enum ClaimTypeEnum {
    MOBILE_NUMBER("mobile-number");

    private String value;

    ClaimTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ClaimTypeEnum fromValue(String value) {
      for (ClaimTypeEnum b : ClaimTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ClaimTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ClaimTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ClaimTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ClaimTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CLAIM_TYPE = "claim-type";
  @SerializedName(SERIALIZED_NAME_CLAIM_TYPE)
  private ClaimTypeEnum claimType;

  public static final String SERIALIZED_NAME_DATE_OF_BIRTH = "date-of-birth";
  @SerializedName(SERIALIZED_NAME_DATE_OF_BIRTH)
  private LocalDate dateOfBirth;

  public static final String SERIALIZED_NAME_GIVEN_NAME = "given-name";
  @SerializedName(SERIALIZED_NAME_GIVEN_NAME)
  private String givenName;

  public static final String SERIALIZED_NAME_SURNAME = "surname";
  @SerializedName(SERIALIZED_NAME_SURNAME)
  private String surname;

  public static final String SERIALIZED_NAME_MIDDLE_NAME = "middle-name";
  @SerializedName(SERIALIZED_NAME_MIDDLE_NAME)
  private String middleName;

  public static final String SERIALIZED_NAME_TRADING_NAME = "trading-name";
  @SerializedName(SERIALIZED_NAME_TRADING_NAME)
  private String tradingName;

  public static final String SERIALIZED_NAME_TRADING_ADDRESS = "trading-address";
  @SerializedName(SERIALIZED_NAME_TRADING_ADDRESS)
  private BothBuildingNameAndBuildingNumberProperty tradingAddress;

  public static final String SERIALIZED_NAME_EMAIL_ADDRESS = "email-address";
  @SerializedName(SERIALIZED_NAME_EMAIL_ADDRESS)
  private Object emailAddress = null;

  public static final String SERIALIZED_NAME_CITY = "city";
  @SerializedName(SERIALIZED_NAME_CITY)
  private String city;

  public static final String SERIALIZED_NAME_BUILDING_NAME = "building-name";
  @SerializedName(SERIALIZED_NAME_BUILDING_NAME)
  private String buildingName;

  public static final String SERIALIZED_NAME_STREET_NAME = "street-name";
  @SerializedName(SERIALIZED_NAME_STREET_NAME)
  private String streetName;

  public static final String SERIALIZED_NAME_ENTITY_NAME = "entity-name";
  @SerializedName(SERIALIZED_NAME_ENTITY_NAME)
  private String entityName;

  public static final String SERIALIZED_NAME_POSTAL_CODE = "postal-code";
  @SerializedName(SERIALIZED_NAME_POSTAL_CODE)
  private String postalCode;

  /**
   * Gets or Sets corporationType
   */
  @JsonAdapter(CorporationTypeEnum.Adapter.class)
 public enum CorporationTypeEnum {
    PRIVATE_LIMITED_GUARANT_NSC_LIMITED_EXEMPTION("private-limited-guarant-nsc-limited-exemption"),
    
    EEIG("eeig"),
    
    PRIVATE_LIMITED_SHARES_SECTION_30_EXEMPTION("private-limited-shares-section-30-exemption"),
    
    LIMITED_PARTNERSHIP("limited-partnership"),
    
    ROYAL_CHARTER("royal-charter"),
    
    PRIVATE_UNLIMITED_NSC("private-unlimited-nsc"),
    
    OLD_PUBLIC_COMPANY("old-public-company"),
    
    INVESTMENT_COMPANY_WITH_VARIABLE_CAPITAL("investment-company-with-variable-capital"),
    
    OTHER_COMPANY_TYPE("other-company-type"),
    
    CONVERTED_OR_CLOSED("converted-or-closed"),
    
    PROTECTED_CELL_COMPANY("protected-cell-company"),
    
    PRIVATE_LIMITED_GUARANT_NSC("private-limited-guarant-nsc"),
    
    SCOTTISH_CHARITABLE_INCORPORATED_ORGANISATION("scottish-charitable-incorporated-organisation"),
    
    INDUSTRIAL_AND_PROVIDENT_SOCIETY("industrial-and-provident-society"),
    
    REGISTERED_SOCIETY_NON_JURISDICTIONAL("registered-society-non-jurisdictional"),
    
    PRIVATE_UNLIMITED("private-unlimited"),
    
    FURTHER_EDUCATION_OR_SIXTH_FORM_COLLEGE_CORPORATION("further-education-or-sixth-form-college-corporation"),
    
    LIMITED_LIABILITY_PARTNERSHIP("limited-liability-partnership"),
    
    ASSURANCE_COMPANY("assurance-company"),
    
    OTHER("other"),
    
    NORTHERN_IRELAND_OTHER("northern-ireland-other"),
    
    CHARITABLE_INCORPORATED_ORGANISATION("charitable-incorporated-organisation"),
    
    OVERSEA_COMPANY("oversea-company"),
    
    ICVC_SECURITIES("icvc-securities"),
    
    UK_ESTABLISHMENT("uk-establishment"),
    
    UNREGISTERED_COMPANY("unregistered-company"),
    
    ICVC_WARRANT("icvc-warrant"),
    
    REGISTERED_OVERSEAS_ENTITY("registered-overseas-entity"),
    
    PUBLIC_LIMITED_COMPANY("public-limited-company"),
    
    PRIVATE_LIMITED_COMPANY("private-limited-company"),
    
    EUROPEAN_PUBLIC_LIMITED_LIABILITY_COMPANY_SE("european-public-limited-liability-company-se"),
    
    PRIVATE_UNLIMTED_NSC("private-unlimted-nsc"),
    
    NORTHERN_IRELAND("northern-ireland"),
    
    ICVC_UMBRELLA("icvc-umbrella"),
    
    SCOTTISH_PARTNERSHIP("scottish-partnership");

    private String value;

    CorporationTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CorporationTypeEnum fromValue(String value) {
      for (CorporationTypeEnum b : CorporationTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CorporationTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CorporationTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CorporationTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CorporationTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CORPORATION_TYPE = "corporation-type";
  @SerializedName(SERIALIZED_NAME_CORPORATION_TYPE)
  private CorporationTypeEnum corporationType;

  public static final String SERIALIZED_NAME_TELEPHONE_NUMBER = "telephone-number";
  @SerializedName(SERIALIZED_NAME_TELEPHONE_NUMBER)
  private Object telephoneNumber = null;

  public static final String SERIALIZED_NAME_BUILDING_NUMBER = "building-number";
  @SerializedName(SERIALIZED_NAME_BUILDING_NUMBER)
  private String buildingNumber;

  public static final String SERIALIZED_NAME_COUNTRY_CODE = "country-code";
  @SerializedName(SERIALIZED_NAME_COUNTRY_CODE)
  private Object countryCode = null;

  public static final String SERIALIZED_NAME_DATE_OF_INCORPORATION = "date-of-incorporation";
  @SerializedName(SERIALIZED_NAME_DATE_OF_INCORPORATION)
  private LocalDate dateOfIncorporation;

  public static final String SERIALIZED_NAME_ENTITY_REGISTRATION_NUMBER = "entity-registration-number";
  @SerializedName(SERIALIZED_NAME_ENTITY_REGISTRATION_NUMBER)
  private String entityRegistrationNumber;

  public static final String SERIALIZED_NAME_INCOME = "income";
  @SerializedName(SERIALIZED_NAME_INCOME)
  private IncomeProperty1 income;

  public static final String SERIALIZED_NAME_INITIAL_DEPOSIT = "initial-deposit";
  @SerializedName(SERIALIZED_NAME_INITIAL_DEPOSIT)
  private InitialDepositProperty1 initialDeposit;

  public static final String SERIALIZED_NAME_INTERNATIONAL_PAYMENTS_COUNTRIES = "international-payments-countries";
  @SerializedName(SERIALIZED_NAME_INTERNATIONAL_PAYMENTS_COUNTRIES)
  private List<Object> internationalPaymentsCountries = null;

  public static final String SERIALIZED_NAME_LEGAL_PERSON_URL = "legal-person-url";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_URL)
  private String legalPersonUrl;

  public static final String SERIALIZED_NAME_OWNERSHIP_PERCENT = "ownership-percent";
  @SerializedName(SERIALIZED_NAME_OWNERSHIP_PERCENT)
  private String ownershipPercent;

  public static final String SERIALIZED_NAME_COMPANIES_HOUSE_URL = "companies-house-url";
  @SerializedName(SERIALIZED_NAME_COMPANIES_HOUSE_URL)
  private String companiesHouseUrl;

  public static final String SERIALIZED_NAME_SENIOR_MANAGER_QUESTION_MARK = "senior-manager?";
  @SerializedName(SERIALIZED_NAME_SENIOR_MANAGER_QUESTION_MARK)
  private Boolean seniorManagerQuestionMark;

  public static final String SERIALIZED_NAME_TAX_RESIDENCY = "tax-residency";
  @SerializedName(SERIALIZED_NAME_TAX_RESIDENCY)
  private Object taxResidency = null;

  /**
   * Gets or Sets ukRegulatoryPermissions
   */
  @JsonAdapter(UkRegulatoryPermissionsEnum.Adapter.class)
 public enum UkRegulatoryPermissionsEnum {
    ELECTRONIC_MONEY_INSTITUTION("electronic-money-institution"),
    
    PAYMENT_INSTITUTION("payment-institution"),
    
    CLIENT_MONEY("client-money"),
    
    BANK("bank");

    private String value;

    UkRegulatoryPermissionsEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UkRegulatoryPermissionsEnum fromValue(String value) {
      for (UkRegulatoryPermissionsEnum b : UkRegulatoryPermissionsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<UkRegulatoryPermissionsEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UkRegulatoryPermissionsEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UkRegulatoryPermissionsEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return UkRegulatoryPermissionsEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_UK_REGULATORY_PERMISSIONS = "uk-regulatory-permissions";
  @SerializedName(SERIALIZED_NAME_UK_REGULATORY_PERMISSIONS)
  private List<UkRegulatoryPermissionsEnum> ukRegulatoryPermissions = null;

  public static final String SERIALIZED_NAME_BUSINESS_DESCRIPTION = "business-description";
  @SerializedName(SERIALIZED_NAME_BUSINESS_DESCRIPTION)
  private String businessDescription;

  /**
   * Gets or Sets individualSourcesOfFunds
   */
  @JsonAdapter(IndividualSourcesOfFundsEnum.Adapter.class)
 public enum IndividualSourcesOfFundsEnum {
    GAMBLING_OR_LOTTERY("gambling-or-lottery"),
    
    INVESTMENTS("investments"),
    
    PROPERTY_OR_ASSET_SALE("property-or-asset-sale"),
    
    SAVINGS("savings"),
    
    SALARY_OR_BONUS("salary-or-bonus"),
    
    STUDENT_LOANS_OR_BURSARY("student-loans-or-bursary"),
    
    RETIREMENT_OR_PENSION("retirement-or-pension"),
    
    LEGAL_SETTLEMENT("legal-settlement"),
    
    FAMILY_OR_GIFTED("family-or-gifted"),
    
    LOAN("loan"),
    
    INHERITANCE("inheritance");

    private String value;

    IndividualSourcesOfFundsEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static IndividualSourcesOfFundsEnum fromValue(String value) {
      for (IndividualSourcesOfFundsEnum b : IndividualSourcesOfFundsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<IndividualSourcesOfFundsEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final IndividualSourcesOfFundsEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public IndividualSourcesOfFundsEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return IndividualSourcesOfFundsEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_INDIVIDUAL_SOURCES_OF_FUNDS = "individual-sources-of-funds";
  @SerializedName(SERIALIZED_NAME_INDIVIDUAL_SOURCES_OF_FUNDS)
  private Set<IndividualSourcesOfFundsEnum> individualSourcesOfFunds = null;

  public static final String SERIALIZED_NAME_BUSINESS_ADDRESS = "business-address";
  @SerializedName(SERIALIZED_NAME_BUSINESS_ADDRESS)
  private BothBuildingNameAndBuildingNumberProperty businessAddress;

  public static final String SERIALIZED_NAME_ANNUAL_TURNOVER = "annual-turnover";
  @SerializedName(SERIALIZED_NAME_ANNUAL_TURNOVER)
  private AnnualTurnoverProperty1 annualTurnover;

  /**
   * Gets or Sets purposesOfAccount
   */
  @JsonAdapter(PurposesOfAccountEnum.Adapter.class)
 public enum PurposesOfAccountEnum {
    SHORT_TERM_INVESTMENT("short-term-investment"),
    
    LONG_TERM_INVESTMENT("long-term-investment"),
    
    SAFEGUARDING("safeguarding"),
    
    STAFF_PAYROLL("staff-payroll"),
    
    CLIENT_MONEY("client-money"),
    
    BUSINESS_EXPENSES("business-expenses"),
    
    RECEIVING_PAYMENTS("receiving-payments"),
    
    OPERATIONAL_SPEND("operational-spend");

    private String value;

    PurposesOfAccountEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PurposesOfAccountEnum fromValue(String value) {
      for (PurposesOfAccountEnum b : PurposesOfAccountEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PurposesOfAccountEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PurposesOfAccountEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PurposesOfAccountEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PurposesOfAccountEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PURPOSES_OF_ACCOUNT = "purposes-of-account";
  @SerializedName(SERIALIZED_NAME_PURPOSES_OF_ACCOUNT)
  private Set<PurposesOfAccountEnum> purposesOfAccount = null;

  public static final String SERIALIZED_NAME_SIC_CODES = "sic-codes";
  @SerializedName(SERIALIZED_NAME_SIC_CODES)
  private List<String> sicCodes = null;

  public static final String SERIALIZED_NAME_INTERNATIONAL_OPERATIONS_COUNTRIES = "international-operations-countries";
  @SerializedName(SERIALIZED_NAME_INTERNATIONAL_OPERATIONS_COUNTRIES)
  private List<Object> internationalOperationsCountries = null;

  /**
   * Gets or Sets sourcesOfFunds
   */
  @JsonAdapter(SourcesOfFundsEnum.Adapter.class)
 public enum SourcesOfFundsEnum {
    GAMBLING_OR_LOTTERY("gambling-or-lottery"),
    
    INVESTMENTS("investments"),
    
    PROPERTY_OR_ASSET_SALE("property-or-asset-sale"),
    
    BUSINESS_INCOME("business-income"),
    
    SAVINGS("savings"),
    
    SALARY_OR_BONUS("salary-or-bonus"),
    
    STUDENT_LOANS_OR_BURSARY("student-loans-or-bursary"),
    
    RETIREMENT_OR_PENSION("retirement-or-pension"),
    
    LEGAL_SETTLEMENT("legal-settlement"),
    
    FAMILY_OR_GIFTED("family-or-gifted"),
    
    LOAN("loan"),
    
    INHERITANCE("inheritance");

    private String value;

    SourcesOfFundsEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SourcesOfFundsEnum fromValue(String value) {
      for (SourcesOfFundsEnum b : SourcesOfFundsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SourcesOfFundsEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SourcesOfFundsEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SourcesOfFundsEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SourcesOfFundsEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SOURCES_OF_FUNDS = "sources-of-funds";
  @SerializedName(SERIALIZED_NAME_SOURCES_OF_FUNDS)
  private Set<SourcesOfFundsEnum> sourcesOfFunds = null;

  /**
   * Gets or Sets relianceVerificationMethods
   */
  @JsonAdapter(RelianceVerificationMethodsEnum.Adapter.class)
 public enum RelianceVerificationMethodsEnum {
    MANUAL_DOCUMENT("manual-document"),
    
    PHYSICAL("physical"),
    
    ELECTRONIC("electronic"),
    
    MANUAL_BIOMETRIC("manual-biometric");

    private String value;

    RelianceVerificationMethodsEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RelianceVerificationMethodsEnum fromValue(String value) {
      for (RelianceVerificationMethodsEnum b : RelianceVerificationMethodsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RelianceVerificationMethodsEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RelianceVerificationMethodsEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RelianceVerificationMethodsEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RelianceVerificationMethodsEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_RELIANCE_VERIFICATION_METHODS = "reliance-verification-methods";
  @SerializedName(SERIALIZED_NAME_RELIANCE_VERIFICATION_METHODS)
  private Set<RelianceVerificationMethodsEnum> relianceVerificationMethods = null;

  /**
   * Gets or Sets relianceVerificationStandard
   */
  @JsonAdapter(RelianceVerificationStandardEnum.Adapter.class)
 public enum RelianceVerificationStandardEnum {
    JMLSG("jmlsg");

    private String value;

    RelianceVerificationStandardEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RelianceVerificationStandardEnum fromValue(String value) {
      for (RelianceVerificationStandardEnum b : RelianceVerificationStandardEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RelianceVerificationStandardEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RelianceVerificationStandardEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RelianceVerificationStandardEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RelianceVerificationStandardEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_RELIANCE_VERIFICATION_STANDARD = "reliance-verification-standard";
  @SerializedName(SERIALIZED_NAME_RELIANCE_VERIFICATION_STANDARD)
  private RelianceVerificationStandardEnum relianceVerificationStandard;

  public static final String SERIALIZED_NAME_BUSINESS_NAME = "business-name";
  @SerializedName(SERIALIZED_NAME_BUSINESS_NAME)
  private String businessName;

  /**
   * Gets or Sets individualPurposesOfAccount
   */
  @JsonAdapter(IndividualPurposesOfAccountEnum.Adapter.class)
 public enum IndividualPurposesOfAccountEnum {
    SAVINGS("savings"),
    
    BILLS_AND_REPAYMENT("bills-and-repayment"),
    
    EVERYDAY_SPENDING("everyday-spending");

    private String value;

    IndividualPurposesOfAccountEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static IndividualPurposesOfAccountEnum fromValue(String value) {
      for (IndividualPurposesOfAccountEnum b : IndividualPurposesOfAccountEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<IndividualPurposesOfAccountEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final IndividualPurposesOfAccountEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public IndividualPurposesOfAccountEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return IndividualPurposesOfAccountEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_INDIVIDUAL_PURPOSES_OF_ACCOUNT = "individual-purposes-of-account";
  @SerializedName(SERIALIZED_NAME_INDIVIDUAL_PURPOSES_OF_ACCOUNT)
  private Set<IndividualPurposesOfAccountEnum> individualPurposesOfAccount = null;

  public static final String SERIALIZED_NAME_NATIONALITY = "nationality";
  @SerializedName(SERIALIZED_NAME_NATIONALITY)
  private Object nationality = null;

  public static final String SERIALIZED_NAME_SOCIAL_MEDIA = "social-media";
  @SerializedName(SERIALIZED_NAME_SOCIAL_MEDIA)
  private String socialMedia;

  public static final String SERIALIZED_NAME_WEBSITE_URL = "website-url";
  @SerializedName(SERIALIZED_NAME_WEBSITE_URL)
  private String websiteUrl;

  public static final String SERIALIZED_NAME_TAX_IDENTIFICATION_NUMBER = "tax-identification-number";
  @SerializedName(SERIALIZED_NAME_TAX_IDENTIFICATION_NUMBER)
  private String taxIdentificationNumber;

  public MobileNumber() {
  }

  public MobileNumber mobileNumber(Object mobileNumber) {
    
    
    
    
    this.mobileNumber = mobileNumber;
    return this;
  }

   /**
   * Get mobileNumber
   * @return mobileNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getMobileNumber() {
    return mobileNumber;
  }


  public void setMobileNumber(Object mobileNumber) {
    
    
    
    this.mobileNumber = mobileNumber;
  }


  public MobileNumber claimType(ClaimTypeEnum claimType) {
    
    
    
    
    this.claimType = claimType;
    return this;
  }

   /**
   * Get claimType
   * @return claimType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public ClaimTypeEnum getClaimType() {
    return claimType;
  }


  public void setClaimType(ClaimTypeEnum claimType) {
    
    
    
    this.claimType = claimType;
  }


  public MobileNumber dateOfBirth(LocalDate dateOfBirth) {
    
    
    
    
    this.dateOfBirth = dateOfBirth;
    return this;
  }

   /**
   * ISO 8601 formatted date.
   * @return dateOfBirth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO 8601 formatted date.")

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }


  public void setDateOfBirth(LocalDate dateOfBirth) {
    
    
    
    this.dateOfBirth = dateOfBirth;
  }


  public MobileNumber givenName(String givenName) {
    
    
    
    
    this.givenName = givenName;
    return this;
  }

   /**
   * Get givenName
   * @return givenName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getGivenName() {
    return givenName;
  }


  public void setGivenName(String givenName) {
    
    
    
    this.givenName = givenName;
  }


  public MobileNumber surname(String surname) {
    
    
    
    
    this.surname = surname;
    return this;
  }

   /**
   * Get surname
   * @return surname
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSurname() {
    return surname;
  }


  public void setSurname(String surname) {
    
    
    
    this.surname = surname;
  }


  public MobileNumber middleName(String middleName) {
    
    
    
    
    this.middleName = middleName;
    return this;
  }

   /**
   * Get middleName
   * @return middleName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getMiddleName() {
    return middleName;
  }


  public void setMiddleName(String middleName) {
    
    
    
    this.middleName = middleName;
  }


  public MobileNumber tradingName(String tradingName) {
    
    
    
    
    this.tradingName = tradingName;
    return this;
  }

   /**
   * Get tradingName
   * @return tradingName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTradingName() {
    return tradingName;
  }


  public void setTradingName(String tradingName) {
    
    
    
    this.tradingName = tradingName;
  }


  public MobileNumber tradingAddress(BothBuildingNameAndBuildingNumberProperty tradingAddress) {
    
    
    
    
    this.tradingAddress = tradingAddress;
    return this;
  }

   /**
   * Get tradingAddress
   * @return tradingAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BothBuildingNameAndBuildingNumberProperty getTradingAddress() {
    return tradingAddress;
  }


  public void setTradingAddress(BothBuildingNameAndBuildingNumberProperty tradingAddress) {
    
    
    
    this.tradingAddress = tradingAddress;
  }


  public MobileNumber emailAddress(Object emailAddress) {
    
    
    
    
    this.emailAddress = emailAddress;
    return this;
  }

   /**
   * Get emailAddress
   * @return emailAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getEmailAddress() {
    return emailAddress;
  }


  public void setEmailAddress(Object emailAddress) {
    
    
    
    this.emailAddress = emailAddress;
  }


  public MobileNumber city(String city) {
    
    
    
    
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCity() {
    return city;
  }


  public void setCity(String city) {
    
    
    
    this.city = city;
  }


  public MobileNumber buildingName(String buildingName) {
    
    
    
    
    this.buildingName = buildingName;
    return this;
  }

   /**
   * Get buildingName
   * @return buildingName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getBuildingName() {
    return buildingName;
  }


  public void setBuildingName(String buildingName) {
    
    
    
    this.buildingName = buildingName;
  }


  public MobileNumber streetName(String streetName) {
    
    
    
    
    this.streetName = streetName;
    return this;
  }

   /**
   * Get streetName
   * @return streetName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getStreetName() {
    return streetName;
  }


  public void setStreetName(String streetName) {
    
    
    
    this.streetName = streetName;
  }


  public MobileNumber entityName(String entityName) {
    
    
    
    
    this.entityName = entityName;
    return this;
  }

   /**
   * Get entityName
   * @return entityName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getEntityName() {
    return entityName;
  }


  public void setEntityName(String entityName) {
    
    
    
    this.entityName = entityName;
  }


  public MobileNumber postalCode(String postalCode) {
    
    
    if (postalCode != null && postalCode.length() < 0) {
      throw new IllegalArgumentException("Invalid value for postalCode. Length must be greater than or equal to 0.");
    }
    
    this.postalCode = postalCode;
    return this;
  }

   /**
   * Get postalCode
   * @return postalCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "NW16XE", value = "")

  public String getPostalCode() {
    return postalCode;
  }


  public void setPostalCode(String postalCode) {
    
    
    if (postalCode != null && postalCode.length() < 0) {
      throw new IllegalArgumentException("Invalid value for postalCode. Length must be greater than or equal to 0.");
    }
    this.postalCode = postalCode;
  }


  public MobileNumber corporationType(CorporationTypeEnum corporationType) {
    
    
    
    
    this.corporationType = corporationType;
    return this;
  }

   /**
   * Get corporationType
   * @return corporationType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CorporationTypeEnum getCorporationType() {
    return corporationType;
  }


  public void setCorporationType(CorporationTypeEnum corporationType) {
    
    
    
    this.corporationType = corporationType;
  }


  public MobileNumber telephoneNumber(Object telephoneNumber) {
    
    
    
    
    this.telephoneNumber = telephoneNumber;
    return this;
  }

   /**
   * Get telephoneNumber
   * @return telephoneNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getTelephoneNumber() {
    return telephoneNumber;
  }


  public void setTelephoneNumber(Object telephoneNumber) {
    
    
    
    this.telephoneNumber = telephoneNumber;
  }


  public MobileNumber buildingNumber(String buildingNumber) {
    
    
    
    
    this.buildingNumber = buildingNumber;
    return this;
  }

   /**
   * Get buildingNumber
   * @return buildingNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getBuildingNumber() {
    return buildingNumber;
  }


  public void setBuildingNumber(String buildingNumber) {
    
    
    
    this.buildingNumber = buildingNumber;
  }


  public MobileNumber countryCode(Object countryCode) {
    
    
    
    
    this.countryCode = countryCode;
    return this;
  }

   /**
   * Get countryCode
   * @return countryCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getCountryCode() {
    return countryCode;
  }


  public void setCountryCode(Object countryCode) {
    
    
    
    this.countryCode = countryCode;
  }


  public MobileNumber dateOfIncorporation(LocalDate dateOfIncorporation) {
    
    
    
    
    this.dateOfIncorporation = dateOfIncorporation;
    return this;
  }

   /**
   * ISO 8601 formatted date.
   * @return dateOfIncorporation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO 8601 formatted date.")

  public LocalDate getDateOfIncorporation() {
    return dateOfIncorporation;
  }


  public void setDateOfIncorporation(LocalDate dateOfIncorporation) {
    
    
    
    this.dateOfIncorporation = dateOfIncorporation;
  }


  public MobileNumber entityRegistrationNumber(String entityRegistrationNumber) {
    
    
    if (entityRegistrationNumber != null && entityRegistrationNumber.length() < 1) {
      throw new IllegalArgumentException("Invalid value for entityRegistrationNumber. Length must be greater than or equal to 1.");
    }
    
    this.entityRegistrationNumber = entityRegistrationNumber;
    return this;
  }

   /**
   * The entity number assigned by the local register. For UK companies that&#39;s the Companies House company number.
   * @return entityRegistrationNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The entity number assigned by the local register. For UK companies that's the Companies House company number.")

  public String getEntityRegistrationNumber() {
    return entityRegistrationNumber;
  }


  public void setEntityRegistrationNumber(String entityRegistrationNumber) {
    
    
    if (entityRegistrationNumber != null && entityRegistrationNumber.length() < 1) {
      throw new IllegalArgumentException("Invalid value for entityRegistrationNumber. Length must be greater than or equal to 1.");
    }
    this.entityRegistrationNumber = entityRegistrationNumber;
  }


  public MobileNumber income(IncomeProperty1 income) {
    
    
    
    
    this.income = income;
    return this;
  }

   /**
   * Get income
   * @return income
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public IncomeProperty1 getIncome() {
    return income;
  }


  public void setIncome(IncomeProperty1 income) {
    
    
    
    this.income = income;
  }


  public MobileNumber initialDeposit(InitialDepositProperty1 initialDeposit) {
    
    
    
    
    this.initialDeposit = initialDeposit;
    return this;
  }

   /**
   * Get initialDeposit
   * @return initialDeposit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public InitialDepositProperty1 getInitialDeposit() {
    return initialDeposit;
  }


  public void setInitialDeposit(InitialDepositProperty1 initialDeposit) {
    
    
    
    this.initialDeposit = initialDeposit;
  }


  public MobileNumber internationalPaymentsCountries(List<Object> internationalPaymentsCountries) {
    
    
    
    
    this.internationalPaymentsCountries = internationalPaymentsCountries;
    return this;
  }

  public MobileNumber addInternationalPaymentsCountriesItem(Object internationalPaymentsCountriesItem) {
    if (this.internationalPaymentsCountries == null) {
      this.internationalPaymentsCountries = new ArrayList<>();
    }
    this.internationalPaymentsCountries.add(internationalPaymentsCountriesItem);
    return this;
  }

   /**
   * Get internationalPaymentsCountries
   * @return internationalPaymentsCountries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Object> getInternationalPaymentsCountries() {
    return internationalPaymentsCountries;
  }


  public void setInternationalPaymentsCountries(List<Object> internationalPaymentsCountries) {
    
    
    
    this.internationalPaymentsCountries = internationalPaymentsCountries;
  }


  public MobileNumber legalPersonUrl(String legalPersonUrl) {
    
    
    
    
    this.legalPersonUrl = legalPersonUrl;
    return this;
  }

   /**
   * A contextual link to the [legal person](http://docs.griffin.com).
   * @return legalPersonUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA", value = "A contextual link to the [legal person](http://docs.griffin.com).")

  public String getLegalPersonUrl() {
    return legalPersonUrl;
  }


  public void setLegalPersonUrl(String legalPersonUrl) {
    
    
    
    this.legalPersonUrl = legalPersonUrl;
  }


  public MobileNumber ownershipPercent(String ownershipPercent) {
    
    
    
    
    this.ownershipPercent = ownershipPercent;
    return this;
  }

   /**
   * The percentage ownership the legal person has of the corporation.
   * @return ownershipPercent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "12.34", value = "The percentage ownership the legal person has of the corporation.")

  public String getOwnershipPercent() {
    return ownershipPercent;
  }


  public void setOwnershipPercent(String ownershipPercent) {
    
    
    
    this.ownershipPercent = ownershipPercent;
  }


  public MobileNumber companiesHouseUrl(String companiesHouseUrl) {
    
    
    
    
    this.companiesHouseUrl = companiesHouseUrl;
    return this;
  }

   /**
   * The URL of the entity in Companies House
   * @return companiesHouseUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://api.company-information.service.gov.uk/company/00000001/appointments/AbcDEFGhI1JKLmnO2PQ3sTUv4WX", value = "The URL of the entity in Companies House")

  public String getCompaniesHouseUrl() {
    return companiesHouseUrl;
  }


  public void setCompaniesHouseUrl(String companiesHouseUrl) {
    
    
    
    this.companiesHouseUrl = companiesHouseUrl;
  }


  public MobileNumber seniorManagerQuestionMark(Boolean seniorManagerQuestionMark) {
    
    
    
    
    this.seniorManagerQuestionMark = seniorManagerQuestionMark;
    return this;
  }

   /**
   * Get seniorManagerQuestionMark
   * @return seniorManagerQuestionMark
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getSeniorManagerQuestionMark() {
    return seniorManagerQuestionMark;
  }


  public void setSeniorManagerQuestionMark(Boolean seniorManagerQuestionMark) {
    
    
    
    this.seniorManagerQuestionMark = seniorManagerQuestionMark;
  }


  public MobileNumber taxResidency(Object taxResidency) {
    
    
    if (taxResidency != null && taxResidency.length() < 2) {
      throw new IllegalArgumentException("Invalid value for taxResidency. Length must be greater than or equal to 2.");
    }
    
    this.taxResidency = taxResidency;
    return this;
  }

   /**
   * ISO 3166-1 alpha-2 two-letter country code.
   * @return taxResidency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "GB", value = "ISO 3166-1 alpha-2 two-letter country code.")

  public Object getTaxResidency() {
    return taxResidency;
  }


  public void setTaxResidency(Object taxResidency) {
    
    
    if (taxResidency != null && taxResidency.length() < 2) {
      throw new IllegalArgumentException("Invalid value for taxResidency. Length must be greater than or equal to 2.");
    }
    this.taxResidency = taxResidency;
  }


  public MobileNumber ukRegulatoryPermissions(List<UkRegulatoryPermissionsEnum> ukRegulatoryPermissions) {
    
    
    
    
    this.ukRegulatoryPermissions = ukRegulatoryPermissions;
    return this;
  }

  public MobileNumber addUkRegulatoryPermissionsItem(UkRegulatoryPermissionsEnum ukRegulatoryPermissionsItem) {
    if (this.ukRegulatoryPermissions == null) {
      this.ukRegulatoryPermissions = new ArrayList<>();
    }
    this.ukRegulatoryPermissions.add(ukRegulatoryPermissionsItem);
    return this;
  }

   /**
   * Get ukRegulatoryPermissions
   * @return ukRegulatoryPermissions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<UkRegulatoryPermissionsEnum> getUkRegulatoryPermissions() {
    return ukRegulatoryPermissions;
  }


  public void setUkRegulatoryPermissions(List<UkRegulatoryPermissionsEnum> ukRegulatoryPermissions) {
    
    
    
    this.ukRegulatoryPermissions = ukRegulatoryPermissions;
  }


  public MobileNumber businessDescription(String businessDescription) {
    
    
    if (businessDescription != null && businessDescription.length() < 1) {
      throw new IllegalArgumentException("Invalid value for businessDescription. Length must be greater than or equal to 1.");
    }
    
    this.businessDescription = businessDescription;
    return this;
  }

   /**
   * Get businessDescription
   * @return businessDescription
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getBusinessDescription() {
    return businessDescription;
  }


  public void setBusinessDescription(String businessDescription) {
    
    
    if (businessDescription != null && businessDescription.length() < 1) {
      throw new IllegalArgumentException("Invalid value for businessDescription. Length must be greater than or equal to 1.");
    }
    this.businessDescription = businessDescription;
  }


  public MobileNumber individualSourcesOfFunds(Set<IndividualSourcesOfFundsEnum> individualSourcesOfFunds) {
    
    
    
    
    this.individualSourcesOfFunds = individualSourcesOfFunds;
    return this;
  }

  public MobileNumber addIndividualSourcesOfFundsItem(IndividualSourcesOfFundsEnum individualSourcesOfFundsItem) {
    if (this.individualSourcesOfFunds == null) {
      this.individualSourcesOfFunds = new LinkedHashSet<>();
    }
    this.individualSourcesOfFunds.add(individualSourcesOfFundsItem);
    return this;
  }

   /**
   * Get individualSourcesOfFunds
   * @return individualSourcesOfFunds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Set<IndividualSourcesOfFundsEnum> getIndividualSourcesOfFunds() {
    return individualSourcesOfFunds;
  }


  public void setIndividualSourcesOfFunds(Set<IndividualSourcesOfFundsEnum> individualSourcesOfFunds) {
    
    
    
    this.individualSourcesOfFunds = individualSourcesOfFunds;
  }


  public MobileNumber businessAddress(BothBuildingNameAndBuildingNumberProperty businessAddress) {
    
    
    
    
    this.businessAddress = businessAddress;
    return this;
  }

   /**
   * Get businessAddress
   * @return businessAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BothBuildingNameAndBuildingNumberProperty getBusinessAddress() {
    return businessAddress;
  }


  public void setBusinessAddress(BothBuildingNameAndBuildingNumberProperty businessAddress) {
    
    
    
    this.businessAddress = businessAddress;
  }


  public MobileNumber annualTurnover(AnnualTurnoverProperty1 annualTurnover) {
    
    
    
    
    this.annualTurnover = annualTurnover;
    return this;
  }

   /**
   * Get annualTurnover
   * @return annualTurnover
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public AnnualTurnoverProperty1 getAnnualTurnover() {
    return annualTurnover;
  }


  public void setAnnualTurnover(AnnualTurnoverProperty1 annualTurnover) {
    
    
    
    this.annualTurnover = annualTurnover;
  }


  public MobileNumber purposesOfAccount(Set<PurposesOfAccountEnum> purposesOfAccount) {
    
    
    
    
    this.purposesOfAccount = purposesOfAccount;
    return this;
  }

  public MobileNumber addPurposesOfAccountItem(PurposesOfAccountEnum purposesOfAccountItem) {
    if (this.purposesOfAccount == null) {
      this.purposesOfAccount = new LinkedHashSet<>();
    }
    this.purposesOfAccount.add(purposesOfAccountItem);
    return this;
  }

   /**
   * Get purposesOfAccount
   * @return purposesOfAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Set<PurposesOfAccountEnum> getPurposesOfAccount() {
    return purposesOfAccount;
  }


  public void setPurposesOfAccount(Set<PurposesOfAccountEnum> purposesOfAccount) {
    
    
    
    this.purposesOfAccount = purposesOfAccount;
  }


  public MobileNumber sicCodes(List<String> sicCodes) {
    
    
    
    
    this.sicCodes = sicCodes;
    return this;
  }

  public MobileNumber addSicCodesItem(String sicCodesItem) {
    if (this.sicCodes == null) {
      this.sicCodes = new ArrayList<>();
    }
    this.sicCodes.add(sicCodesItem);
    return this;
  }

   /**
   * Get sicCodes
   * @return sicCodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getSicCodes() {
    return sicCodes;
  }


  public void setSicCodes(List<String> sicCodes) {
    
    
    
    this.sicCodes = sicCodes;
  }


  public MobileNumber internationalOperationsCountries(List<Object> internationalOperationsCountries) {
    
    
    
    
    this.internationalOperationsCountries = internationalOperationsCountries;
    return this;
  }

  public MobileNumber addInternationalOperationsCountriesItem(Object internationalOperationsCountriesItem) {
    if (this.internationalOperationsCountries == null) {
      this.internationalOperationsCountries = new ArrayList<>();
    }
    this.internationalOperationsCountries.add(internationalOperationsCountriesItem);
    return this;
  }

   /**
   * Get internationalOperationsCountries
   * @return internationalOperationsCountries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Object> getInternationalOperationsCountries() {
    return internationalOperationsCountries;
  }


  public void setInternationalOperationsCountries(List<Object> internationalOperationsCountries) {
    
    
    
    this.internationalOperationsCountries = internationalOperationsCountries;
  }


  public MobileNumber sourcesOfFunds(Set<SourcesOfFundsEnum> sourcesOfFunds) {
    
    
    
    
    this.sourcesOfFunds = sourcesOfFunds;
    return this;
  }

  public MobileNumber addSourcesOfFundsItem(SourcesOfFundsEnum sourcesOfFundsItem) {
    if (this.sourcesOfFunds == null) {
      this.sourcesOfFunds = new LinkedHashSet<>();
    }
    this.sourcesOfFunds.add(sourcesOfFundsItem);
    return this;
  }

   /**
   * Get sourcesOfFunds
   * @return sourcesOfFunds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Set<SourcesOfFundsEnum> getSourcesOfFunds() {
    return sourcesOfFunds;
  }


  public void setSourcesOfFunds(Set<SourcesOfFundsEnum> sourcesOfFunds) {
    
    
    
    this.sourcesOfFunds = sourcesOfFunds;
  }


  public MobileNumber relianceVerificationMethods(Set<RelianceVerificationMethodsEnum> relianceVerificationMethods) {
    
    
    
    
    this.relianceVerificationMethods = relianceVerificationMethods;
    return this;
  }

  public MobileNumber addRelianceVerificationMethodsItem(RelianceVerificationMethodsEnum relianceVerificationMethodsItem) {
    if (this.relianceVerificationMethods == null) {
      this.relianceVerificationMethods = new LinkedHashSet<>();
    }
    this.relianceVerificationMethods.add(relianceVerificationMethodsItem);
    return this;
  }

   /**
   * Get relianceVerificationMethods
   * @return relianceVerificationMethods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Set<RelianceVerificationMethodsEnum> getRelianceVerificationMethods() {
    return relianceVerificationMethods;
  }


  public void setRelianceVerificationMethods(Set<RelianceVerificationMethodsEnum> relianceVerificationMethods) {
    
    
    
    this.relianceVerificationMethods = relianceVerificationMethods;
  }


  public MobileNumber relianceVerificationStandard(RelianceVerificationStandardEnum relianceVerificationStandard) {
    
    
    
    
    this.relianceVerificationStandard = relianceVerificationStandard;
    return this;
  }

   /**
   * Get relianceVerificationStandard
   * @return relianceVerificationStandard
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public RelianceVerificationStandardEnum getRelianceVerificationStandard() {
    return relianceVerificationStandard;
  }


  public void setRelianceVerificationStandard(RelianceVerificationStandardEnum relianceVerificationStandard) {
    
    
    
    this.relianceVerificationStandard = relianceVerificationStandard;
  }


  public MobileNumber businessName(String businessName) {
    
    
    
    
    this.businessName = businessName;
    return this;
  }

   /**
   * Get businessName
   * @return businessName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getBusinessName() {
    return businessName;
  }


  public void setBusinessName(String businessName) {
    
    
    
    this.businessName = businessName;
  }


  public MobileNumber individualPurposesOfAccount(Set<IndividualPurposesOfAccountEnum> individualPurposesOfAccount) {
    
    
    
    
    this.individualPurposesOfAccount = individualPurposesOfAccount;
    return this;
  }

  public MobileNumber addIndividualPurposesOfAccountItem(IndividualPurposesOfAccountEnum individualPurposesOfAccountItem) {
    if (this.individualPurposesOfAccount == null) {
      this.individualPurposesOfAccount = new LinkedHashSet<>();
    }
    this.individualPurposesOfAccount.add(individualPurposesOfAccountItem);
    return this;
  }

   /**
   * Get individualPurposesOfAccount
   * @return individualPurposesOfAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Set<IndividualPurposesOfAccountEnum> getIndividualPurposesOfAccount() {
    return individualPurposesOfAccount;
  }


  public void setIndividualPurposesOfAccount(Set<IndividualPurposesOfAccountEnum> individualPurposesOfAccount) {
    
    
    
    this.individualPurposesOfAccount = individualPurposesOfAccount;
  }


  public MobileNumber nationality(Object nationality) {
    
    
    if (nationality != null && nationality.length() < 2) {
      throw new IllegalArgumentException("Invalid value for nationality. Length must be greater than or equal to 2.");
    }
    
    this.nationality = nationality;
    return this;
  }

   /**
   * ISO 3166-1 alpha-2 two-letter country code.
   * @return nationality
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "GB", value = "ISO 3166-1 alpha-2 two-letter country code.")

  public Object getNationality() {
    return nationality;
  }


  public void setNationality(Object nationality) {
    
    
    if (nationality != null && nationality.length() < 2) {
      throw new IllegalArgumentException("Invalid value for nationality. Length must be greater than or equal to 2.");
    }
    this.nationality = nationality;
  }


  public MobileNumber socialMedia(String socialMedia) {
    
    
    if (socialMedia != null && socialMedia.length() < 1) {
      throw new IllegalArgumentException("Invalid value for socialMedia. Length must be greater than or equal to 1.");
    }
    
    this.socialMedia = socialMedia;
    return this;
  }

   /**
   * Get socialMedia
   * @return socialMedia
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSocialMedia() {
    return socialMedia;
  }


  public void setSocialMedia(String socialMedia) {
    
    
    if (socialMedia != null && socialMedia.length() < 1) {
      throw new IllegalArgumentException("Invalid value for socialMedia. Length must be greater than or equal to 1.");
    }
    this.socialMedia = socialMedia;
  }


  public MobileNumber websiteUrl(String websiteUrl) {
    
    
    
    
    this.websiteUrl = websiteUrl;
    return this;
  }

   /**
   * Get websiteUrl
   * @return websiteUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getWebsiteUrl() {
    return websiteUrl;
  }


  public void setWebsiteUrl(String websiteUrl) {
    
    
    
    this.websiteUrl = websiteUrl;
  }


  public MobileNumber taxIdentificationNumber(String taxIdentificationNumber) {
    
    
    if (taxIdentificationNumber != null && taxIdentificationNumber.length() < 1) {
      throw new IllegalArgumentException("Invalid value for taxIdentificationNumber. Length must be greater than or equal to 1.");
    }
    
    this.taxIdentificationNumber = taxIdentificationNumber;
    return this;
  }

   /**
   * Get taxIdentificationNumber
   * @return taxIdentificationNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTaxIdentificationNumber() {
    return taxIdentificationNumber;
  }


  public void setTaxIdentificationNumber(String taxIdentificationNumber) {
    
    
    if (taxIdentificationNumber != null && taxIdentificationNumber.length() < 1) {
      throw new IllegalArgumentException("Invalid value for taxIdentificationNumber. Length must be greater than or equal to 1.");
    }
    this.taxIdentificationNumber = taxIdentificationNumber;
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
   * @return the MobileNumber instance itself
   */
  public MobileNumber putAdditionalProperty(String key, Object value) {
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
    MobileNumber mobileNumber = (MobileNumber) o;
    return Objects.equals(this.mobileNumber, mobileNumber.mobileNumber) &&
        Objects.equals(this.claimType, mobileNumber.claimType) &&
        Objects.equals(this.dateOfBirth, mobileNumber.dateOfBirth) &&
        Objects.equals(this.givenName, mobileNumber.givenName) &&
        Objects.equals(this.surname, mobileNumber.surname) &&
        Objects.equals(this.middleName, mobileNumber.middleName) &&
        Objects.equals(this.tradingName, mobileNumber.tradingName) &&
        Objects.equals(this.tradingAddress, mobileNumber.tradingAddress) &&
        Objects.equals(this.emailAddress, mobileNumber.emailAddress) &&
        Objects.equals(this.city, mobileNumber.city) &&
        Objects.equals(this.buildingName, mobileNumber.buildingName) &&
        Objects.equals(this.streetName, mobileNumber.streetName) &&
        Objects.equals(this.entityName, mobileNumber.entityName) &&
        Objects.equals(this.postalCode, mobileNumber.postalCode) &&
        Objects.equals(this.corporationType, mobileNumber.corporationType) &&
        Objects.equals(this.telephoneNumber, mobileNumber.telephoneNumber) &&
        Objects.equals(this.buildingNumber, mobileNumber.buildingNumber) &&
        Objects.equals(this.countryCode, mobileNumber.countryCode) &&
        Objects.equals(this.dateOfIncorporation, mobileNumber.dateOfIncorporation) &&
        Objects.equals(this.entityRegistrationNumber, mobileNumber.entityRegistrationNumber) &&
        Objects.equals(this.income, mobileNumber.income) &&
        Objects.equals(this.initialDeposit, mobileNumber.initialDeposit) &&
        Objects.equals(this.internationalPaymentsCountries, mobileNumber.internationalPaymentsCountries) &&
        Objects.equals(this.legalPersonUrl, mobileNumber.legalPersonUrl) &&
        Objects.equals(this.ownershipPercent, mobileNumber.ownershipPercent) &&
        Objects.equals(this.companiesHouseUrl, mobileNumber.companiesHouseUrl) &&
        Objects.equals(this.seniorManagerQuestionMark, mobileNumber.seniorManagerQuestionMark) &&
        Objects.equals(this.taxResidency, mobileNumber.taxResidency) &&
        Objects.equals(this.ukRegulatoryPermissions, mobileNumber.ukRegulatoryPermissions) &&
        Objects.equals(this.businessDescription, mobileNumber.businessDescription) &&
        Objects.equals(this.individualSourcesOfFunds, mobileNumber.individualSourcesOfFunds) &&
        Objects.equals(this.businessAddress, mobileNumber.businessAddress) &&
        Objects.equals(this.annualTurnover, mobileNumber.annualTurnover) &&
        Objects.equals(this.purposesOfAccount, mobileNumber.purposesOfAccount) &&
        Objects.equals(this.sicCodes, mobileNumber.sicCodes) &&
        Objects.equals(this.internationalOperationsCountries, mobileNumber.internationalOperationsCountries) &&
        Objects.equals(this.sourcesOfFunds, mobileNumber.sourcesOfFunds) &&
        Objects.equals(this.relianceVerificationMethods, mobileNumber.relianceVerificationMethods) &&
        Objects.equals(this.relianceVerificationStandard, mobileNumber.relianceVerificationStandard) &&
        Objects.equals(this.businessName, mobileNumber.businessName) &&
        Objects.equals(this.individualPurposesOfAccount, mobileNumber.individualPurposesOfAccount) &&
        Objects.equals(this.nationality, mobileNumber.nationality) &&
        Objects.equals(this.socialMedia, mobileNumber.socialMedia) &&
        Objects.equals(this.websiteUrl, mobileNumber.websiteUrl) &&
        Objects.equals(this.taxIdentificationNumber, mobileNumber.taxIdentificationNumber)&&
        Objects.equals(this.additionalProperties, mobileNumber.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(mobileNumber, claimType, dateOfBirth, givenName, surname, middleName, tradingName, tradingAddress, emailAddress, city, buildingName, streetName, entityName, postalCode, corporationType, telephoneNumber, buildingNumber, countryCode, dateOfIncorporation, entityRegistrationNumber, income, initialDeposit, internationalPaymentsCountries, legalPersonUrl, ownershipPercent, companiesHouseUrl, seniorManagerQuestionMark, taxResidency, ukRegulatoryPermissions, businessDescription, individualSourcesOfFunds, businessAddress, annualTurnover, purposesOfAccount, sicCodes, internationalOperationsCountries, sourcesOfFunds, relianceVerificationMethods, relianceVerificationStandard, businessName, individualPurposesOfAccount, nationality, socialMedia, websiteUrl, taxIdentificationNumber, additionalProperties);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MobileNumber {\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    claimType: ").append(toIndentedString(claimType)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    tradingName: ").append(toIndentedString(tradingName)).append("\n");
    sb.append("    tradingAddress: ").append(toIndentedString(tradingAddress)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    buildingName: ").append(toIndentedString(buildingName)).append("\n");
    sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
    sb.append("    entityName: ").append(toIndentedString(entityName)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    corporationType: ").append(toIndentedString(corporationType)).append("\n");
    sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
    sb.append("    buildingNumber: ").append(toIndentedString(buildingNumber)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    dateOfIncorporation: ").append(toIndentedString(dateOfIncorporation)).append("\n");
    sb.append("    entityRegistrationNumber: ").append(toIndentedString(entityRegistrationNumber)).append("\n");
    sb.append("    income: ").append(toIndentedString(income)).append("\n");
    sb.append("    initialDeposit: ").append(toIndentedString(initialDeposit)).append("\n");
    sb.append("    internationalPaymentsCountries: ").append(toIndentedString(internationalPaymentsCountries)).append("\n");
    sb.append("    legalPersonUrl: ").append(toIndentedString(legalPersonUrl)).append("\n");
    sb.append("    ownershipPercent: ").append(toIndentedString(ownershipPercent)).append("\n");
    sb.append("    companiesHouseUrl: ").append(toIndentedString(companiesHouseUrl)).append("\n");
    sb.append("    seniorManagerQuestionMark: ").append(toIndentedString(seniorManagerQuestionMark)).append("\n");
    sb.append("    taxResidency: ").append(toIndentedString(taxResidency)).append("\n");
    sb.append("    ukRegulatoryPermissions: ").append(toIndentedString(ukRegulatoryPermissions)).append("\n");
    sb.append("    businessDescription: ").append(toIndentedString(businessDescription)).append("\n");
    sb.append("    individualSourcesOfFunds: ").append(toIndentedString(individualSourcesOfFunds)).append("\n");
    sb.append("    businessAddress: ").append(toIndentedString(businessAddress)).append("\n");
    sb.append("    annualTurnover: ").append(toIndentedString(annualTurnover)).append("\n");
    sb.append("    purposesOfAccount: ").append(toIndentedString(purposesOfAccount)).append("\n");
    sb.append("    sicCodes: ").append(toIndentedString(sicCodes)).append("\n");
    sb.append("    internationalOperationsCountries: ").append(toIndentedString(internationalOperationsCountries)).append("\n");
    sb.append("    sourcesOfFunds: ").append(toIndentedString(sourcesOfFunds)).append("\n");
    sb.append("    relianceVerificationMethods: ").append(toIndentedString(relianceVerificationMethods)).append("\n");
    sb.append("    relianceVerificationStandard: ").append(toIndentedString(relianceVerificationStandard)).append("\n");
    sb.append("    businessName: ").append(toIndentedString(businessName)).append("\n");
    sb.append("    individualPurposesOfAccount: ").append(toIndentedString(individualPurposesOfAccount)).append("\n");
    sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
    sb.append("    socialMedia: ").append(toIndentedString(socialMedia)).append("\n");
    sb.append("    websiteUrl: ").append(toIndentedString(websiteUrl)).append("\n");
    sb.append("    taxIdentificationNumber: ").append(toIndentedString(taxIdentificationNumber)).append("\n");
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
    openapiFields.add("mobile-number");
    openapiFields.add("claim-type");
    openapiFields.add("date-of-birth");
    openapiFields.add("given-name");
    openapiFields.add("surname");
    openapiFields.add("middle-name");
    openapiFields.add("trading-name");
    openapiFields.add("trading-address");
    openapiFields.add("email-address");
    openapiFields.add("city");
    openapiFields.add("building-name");
    openapiFields.add("street-name");
    openapiFields.add("entity-name");
    openapiFields.add("postal-code");
    openapiFields.add("corporation-type");
    openapiFields.add("telephone-number");
    openapiFields.add("building-number");
    openapiFields.add("country-code");
    openapiFields.add("date-of-incorporation");
    openapiFields.add("entity-registration-number");
    openapiFields.add("income");
    openapiFields.add("initial-deposit");
    openapiFields.add("international-payments-countries");
    openapiFields.add("legal-person-url");
    openapiFields.add("ownership-percent");
    openapiFields.add("companies-house-url");
    openapiFields.add("senior-manager?");
    openapiFields.add("tax-residency");
    openapiFields.add("uk-regulatory-permissions");
    openapiFields.add("business-description");
    openapiFields.add("individual-sources-of-funds");
    openapiFields.add("business-address");
    openapiFields.add("annual-turnover");
    openapiFields.add("purposes-of-account");
    openapiFields.add("sic-codes");
    openapiFields.add("international-operations-countries");
    openapiFields.add("sources-of-funds");
    openapiFields.add("reliance-verification-methods");
    openapiFields.add("reliance-verification-standard");
    openapiFields.add("business-name");
    openapiFields.add("individual-purposes-of-account");
    openapiFields.add("nationality");
    openapiFields.add("social-media");
    openapiFields.add("website-url");
    openapiFields.add("tax-identification-number");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("claim-type");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to MobileNumber
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!MobileNumber.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in MobileNumber is not found in the empty JSON string", MobileNumber.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : MobileNumber.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("claim-type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `claim-type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("claim-type").toString()));
      }
      if ((jsonObj.get("given-name") != null && !jsonObj.get("given-name").isJsonNull()) && !jsonObj.get("given-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `given-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("given-name").toString()));
      }
      if ((jsonObj.get("surname") != null && !jsonObj.get("surname").isJsonNull()) && !jsonObj.get("surname").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `surname` to be a primitive type in the JSON string but got `%s`", jsonObj.get("surname").toString()));
      }
      if ((jsonObj.get("middle-name") != null && !jsonObj.get("middle-name").isJsonNull()) && !jsonObj.get("middle-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `middle-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("middle-name").toString()));
      }
      if ((jsonObj.get("trading-name") != null && !jsonObj.get("trading-name").isJsonNull()) && !jsonObj.get("trading-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `trading-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("trading-name").toString()));
      }
      // validate the optional field `trading-address`
      if (jsonObj.get("trading-address") != null && !jsonObj.get("trading-address").isJsonNull()) {
        BothBuildingNameAndBuildingNumberProperty.validateJsonObject(jsonObj.getAsJsonObject("trading-address"));
      }
      if ((jsonObj.get("city") != null && !jsonObj.get("city").isJsonNull()) && !jsonObj.get("city").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `city` to be a primitive type in the JSON string but got `%s`", jsonObj.get("city").toString()));
      }
      if ((jsonObj.get("building-name") != null && !jsonObj.get("building-name").isJsonNull()) && !jsonObj.get("building-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `building-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("building-name").toString()));
      }
      if ((jsonObj.get("street-name") != null && !jsonObj.get("street-name").isJsonNull()) && !jsonObj.get("street-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `street-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("street-name").toString()));
      }
      if ((jsonObj.get("entity-name") != null && !jsonObj.get("entity-name").isJsonNull()) && !jsonObj.get("entity-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `entity-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("entity-name").toString()));
      }
      if ((jsonObj.get("postal-code") != null && !jsonObj.get("postal-code").isJsonNull()) && !jsonObj.get("postal-code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `postal-code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("postal-code").toString()));
      }
      if ((jsonObj.get("corporation-type") != null && !jsonObj.get("corporation-type").isJsonNull()) && !jsonObj.get("corporation-type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `corporation-type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("corporation-type").toString()));
      }
      if ((jsonObj.get("building-number") != null && !jsonObj.get("building-number").isJsonNull()) && !jsonObj.get("building-number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `building-number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("building-number").toString()));
      }
      if ((jsonObj.get("entity-registration-number") != null && !jsonObj.get("entity-registration-number").isJsonNull()) && !jsonObj.get("entity-registration-number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `entity-registration-number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("entity-registration-number").toString()));
      }
      // validate the optional field `income`
      if (jsonObj.get("income") != null && !jsonObj.get("income").isJsonNull()) {
        IncomeProperty1.validateJsonObject(jsonObj.getAsJsonObject("income"));
      }
      // validate the optional field `initial-deposit`
      if (jsonObj.get("initial-deposit") != null && !jsonObj.get("initial-deposit").isJsonNull()) {
        InitialDepositProperty1.validateJsonObject(jsonObj.getAsJsonObject("initial-deposit"));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("international-payments-countries") != null && !jsonObj.get("international-payments-countries").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `international-payments-countries` to be an array in the JSON string but got `%s`", jsonObj.get("international-payments-countries").toString()));
      }
      if ((jsonObj.get("legal-person-url") != null && !jsonObj.get("legal-person-url").isJsonNull()) && !jsonObj.get("legal-person-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-person-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legal-person-url").toString()));
      }
      if ((jsonObj.get("ownership-percent") != null && !jsonObj.get("ownership-percent").isJsonNull()) && !jsonObj.get("ownership-percent").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ownership-percent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ownership-percent").toString()));
      }
      if ((jsonObj.get("companies-house-url") != null && !jsonObj.get("companies-house-url").isJsonNull()) && !jsonObj.get("companies-house-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `companies-house-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("companies-house-url").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("uk-regulatory-permissions") != null && !jsonObj.get("uk-regulatory-permissions").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `uk-regulatory-permissions` to be an array in the JSON string but got `%s`", jsonObj.get("uk-regulatory-permissions").toString()));
      }
      if ((jsonObj.get("business-description") != null && !jsonObj.get("business-description").isJsonNull()) && !jsonObj.get("business-description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `business-description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("business-description").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("individual-sources-of-funds") != null && !jsonObj.get("individual-sources-of-funds").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `individual-sources-of-funds` to be an array in the JSON string but got `%s`", jsonObj.get("individual-sources-of-funds").toString()));
      }
      // validate the optional field `business-address`
      if (jsonObj.get("business-address") != null && !jsonObj.get("business-address").isJsonNull()) {
        BothBuildingNameAndBuildingNumberProperty.validateJsonObject(jsonObj.getAsJsonObject("business-address"));
      }
      // validate the optional field `annual-turnover`
      if (jsonObj.get("annual-turnover") != null && !jsonObj.get("annual-turnover").isJsonNull()) {
        AnnualTurnoverProperty1.validateJsonObject(jsonObj.getAsJsonObject("annual-turnover"));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("purposes-of-account") != null && !jsonObj.get("purposes-of-account").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `purposes-of-account` to be an array in the JSON string but got `%s`", jsonObj.get("purposes-of-account").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("sic-codes") != null && !jsonObj.get("sic-codes").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `sic-codes` to be an array in the JSON string but got `%s`", jsonObj.get("sic-codes").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("international-operations-countries") != null && !jsonObj.get("international-operations-countries").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `international-operations-countries` to be an array in the JSON string but got `%s`", jsonObj.get("international-operations-countries").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("sources-of-funds") != null && !jsonObj.get("sources-of-funds").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `sources-of-funds` to be an array in the JSON string but got `%s`", jsonObj.get("sources-of-funds").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("reliance-verification-methods") != null && !jsonObj.get("reliance-verification-methods").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `reliance-verification-methods` to be an array in the JSON string but got `%s`", jsonObj.get("reliance-verification-methods").toString()));
      }
      if ((jsonObj.get("reliance-verification-standard") != null && !jsonObj.get("reliance-verification-standard").isJsonNull()) && !jsonObj.get("reliance-verification-standard").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `reliance-verification-standard` to be a primitive type in the JSON string but got `%s`", jsonObj.get("reliance-verification-standard").toString()));
      }
      if ((jsonObj.get("business-name") != null && !jsonObj.get("business-name").isJsonNull()) && !jsonObj.get("business-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `business-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("business-name").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("individual-purposes-of-account") != null && !jsonObj.get("individual-purposes-of-account").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `individual-purposes-of-account` to be an array in the JSON string but got `%s`", jsonObj.get("individual-purposes-of-account").toString()));
      }
      if ((jsonObj.get("social-media") != null && !jsonObj.get("social-media").isJsonNull()) && !jsonObj.get("social-media").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `social-media` to be a primitive type in the JSON string but got `%s`", jsonObj.get("social-media").toString()));
      }
      if ((jsonObj.get("website-url") != null && !jsonObj.get("website-url").isJsonNull()) && !jsonObj.get("website-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `website-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("website-url").toString()));
      }
      if ((jsonObj.get("tax-identification-number") != null && !jsonObj.get("tax-identification-number").isJsonNull()) && !jsonObj.get("tax-identification-number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tax-identification-number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tax-identification-number").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!MobileNumber.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'MobileNumber' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<MobileNumber> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(MobileNumber.class));

       return (TypeAdapter<T>) new TypeAdapter<MobileNumber>() {
           @Override
           public void write(JsonWriter out, MobileNumber value) throws IOException {
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
           public MobileNumber read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             MobileNumber instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of MobileNumber given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of MobileNumber
  * @throws IOException if the JSON string is invalid with respect to MobileNumber
  */
  public static MobileNumber fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, MobileNumber.class);
  }

 /**
  * Convert an instance of MobileNumber to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

