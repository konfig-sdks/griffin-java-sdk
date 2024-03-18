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
import com.konfigthis.client.model.Role5;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
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
 * OrganizationProperty1
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class OrganizationProperty1 {
  public static final String SERIALIZED_NAME_OWN_LEGAL_PERSON_URL = "own-legal-person-url";
  @SerializedName(SERIALIZED_NAME_OWN_LEGAL_PERSON_URL)
  private String ownLegalPersonUrl;

  /**
   * The organization can either be a sandbox organization or a live one; Check out our guide for [sandbox mode vs live mode](http://docs.griffin.com).
   */
  @JsonAdapter(OrganizationModeEnum.Adapter.class)
 public enum OrganizationModeEnum {
    TEST_MODE("test-mode"),
    
    LIVE_MODE("live-mode");

    private String value;

    OrganizationModeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OrganizationModeEnum fromValue(String value) {
      for (OrganizationModeEnum b : OrganizationModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<OrganizationModeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OrganizationModeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OrganizationModeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return OrganizationModeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ORGANIZATION_MODE = "organization-mode";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_MODE)
  private OrganizationModeEnum organizationMode;

  public static final String SERIALIZED_NAME_ORGANIZATION_MEMBERSHIPS_URL = "organization-memberships-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_MEMBERSHIPS_URL)
  private String organizationMembershipsUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_INVITATIONS_URL = "organization-invitations-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_INVITATIONS_URL)
  private String organizationInvitationsUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_ONBOARDING_APPLICATIONS_URL = "organization-onboarding-applications-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_ONBOARDING_APPLICATIONS_URL)
  private String organizationOnboardingApplicationsUrl;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display-name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_ORGANIZATION_API_KEYS_URL = "organization-api-keys-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_API_KEYS_URL)
  private String organizationApiKeysUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_LIVE_ACCESS_URL = "organization-live-access-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_LIVE_ACCESS_URL)
  private String organizationLiveAccessUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_WEBHOOKS_URL = "organization-webhooks-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_WEBHOOKS_URL)
  private String organizationWebhooksUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_WORKFLOWS_URL = "organization-workflows-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_WORKFLOWS_URL)
  private String organizationWorkflowsUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_BANK_ACCOUNTS_URL = "organization-bank-accounts-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_BANK_ACCOUNTS_URL)
  private String organizationBankAccountsUrl;

  public static final String SERIALIZED_NAME_AVAILABLE_ROLES = "available-roles";
  @SerializedName(SERIALIZED_NAME_AVAILABLE_ROLES)
  private List<Role5> availableRoles = new ArrayList<>();

  public static final String SERIALIZED_NAME_CAN_DECIDE_ON_VERIFICATIONS_QUESTION_MARK = "can-decide-on-verifications?";
  @SerializedName(SERIALIZED_NAME_CAN_DECIDE_ON_VERIFICATIONS_QUESTION_MARK)
  private Boolean canDecideOnVerificationsQuestionMark;

  public static final String SERIALIZED_NAME_ORGANIZATION_URL = "organization-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_URL)
  private String organizationUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_INDIVIDUALS_URL = "organization-individuals-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_INDIVIDUALS_URL)
  private String organizationIndividualsUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_CORPORATIONS_URL = "organization-corporations-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_CORPORATIONS_URL)
  private String organizationCorporationsUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_LEGAL_PERSONS_URL = "organization-legal-persons-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_LEGAL_PERSONS_URL)
  private String organizationLegalPersonsUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_EVENTS_URL = "organization-events-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_EVENTS_URL)
  private String organizationEventsUrl;

  public OrganizationProperty1() {
  }

  public OrganizationProperty1 ownLegalPersonUrl(String ownLegalPersonUrl) {
    
    
    
    
    this.ownLegalPersonUrl = ownLegalPersonUrl;
    return this;
  }

   /**
   * Link to the [legal person](http://docs.griffin.com) that represents the [organization](http://docs.griffin.com); this can be an individual or a company.
   * @return ownLegalPersonUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA", required = true, value = "Link to the [legal person](http://docs.griffin.com) that represents the [organization](http://docs.griffin.com); this can be an individual or a company.")

  public String getOwnLegalPersonUrl() {
    return ownLegalPersonUrl;
  }


  public void setOwnLegalPersonUrl(String ownLegalPersonUrl) {
    
    
    
    this.ownLegalPersonUrl = ownLegalPersonUrl;
  }


  public OrganizationProperty1 organizationMode(OrganizationModeEnum organizationMode) {
    
    
    
    
    this.organizationMode = organizationMode;
    return this;
  }

   /**
   * The organization can either be a sandbox organization or a live one; Check out our guide for [sandbox mode vs live mode](http://docs.griffin.com).
   * @return organizationMode
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The organization can either be a sandbox organization or a live one; Check out our guide for [sandbox mode vs live mode](http://docs.griffin.com).")

  public OrganizationModeEnum getOrganizationMode() {
    return organizationMode;
  }


  public void setOrganizationMode(OrganizationModeEnum organizationMode) {
    
    
    
    this.organizationMode = organizationMode;
  }


  public OrganizationProperty1 organizationMembershipsUrl(String organizationMembershipsUrl) {
    
    
    
    
    this.organizationMembershipsUrl = organizationMembershipsUrl;
    return this;
  }

   /**
   * Link to the [memberships](http://docs.griffin.com) for this [organization](http://docs.griffin.com).
   * @return organizationMembershipsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/memberships", required = true, value = "Link to the [memberships](http://docs.griffin.com) for this [organization](http://docs.griffin.com).")

  public String getOrganizationMembershipsUrl() {
    return organizationMembershipsUrl;
  }


  public void setOrganizationMembershipsUrl(String organizationMembershipsUrl) {
    
    
    
    this.organizationMembershipsUrl = organizationMembershipsUrl;
  }


  public OrganizationProperty1 organizationInvitationsUrl(String organizationInvitationsUrl) {
    
    
    
    
    this.organizationInvitationsUrl = organizationInvitationsUrl;
    return this;
  }

   /**
   * Link to the resource that enables you to [invite](http://docs.griffin.com) new [users](http://docs.griffin.com) to this [organization](http://docs.griffin.com).
   * @return organizationInvitationsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/invitations", required = true, value = "Link to the resource that enables you to [invite](http://docs.griffin.com) new [users](http://docs.griffin.com) to this [organization](http://docs.griffin.com).")

  public String getOrganizationInvitationsUrl() {
    return organizationInvitationsUrl;
  }


  public void setOrganizationInvitationsUrl(String organizationInvitationsUrl) {
    
    
    
    this.organizationInvitationsUrl = organizationInvitationsUrl;
  }


  public OrganizationProperty1 organizationOnboardingApplicationsUrl(String organizationOnboardingApplicationsUrl) {
    
    
    
    
    this.organizationOnboardingApplicationsUrl = organizationOnboardingApplicationsUrl;
    return this;
  }

   /**
   * Link to the [Reliance onboarding](http://docs.griffin.com).
   * @return organizationOnboardingApplicationsUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/onboarding/applications", value = "Link to the [Reliance onboarding](http://docs.griffin.com).")

  public String getOrganizationOnboardingApplicationsUrl() {
    return organizationOnboardingApplicationsUrl;
  }


  public void setOrganizationOnboardingApplicationsUrl(String organizationOnboardingApplicationsUrl) {
    
    
    
    this.organizationOnboardingApplicationsUrl = organizationOnboardingApplicationsUrl;
  }


  public OrganizationProperty1 displayName(String displayName) {
    
    
    if (displayName != null && displayName.length() < 1) {
      throw new IllegalArgumentException("Invalid value for displayName. Length must be greater than or equal to 1.");
    }
    
    this.displayName = displayName;
    return this;
  }

   /**
   * The mutable display name for the Organisation
   * @return displayName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Company Org", required = true, value = "The mutable display name for the Organisation")

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    
    
    if (displayName != null && displayName.length() < 1) {
      throw new IllegalArgumentException("Invalid value for displayName. Length must be greater than or equal to 1.");
    }
    this.displayName = displayName;
  }


  public OrganizationProperty1 organizationApiKeysUrl(String organizationApiKeysUrl) {
    
    
    
    
    this.organizationApiKeysUrl = organizationApiKeysUrl;
    return this;
  }

   /**
   * Get organizationApiKeysUrl
   * @return organizationApiKeysUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/api-keys", required = true, value = "")

  public String getOrganizationApiKeysUrl() {
    return organizationApiKeysUrl;
  }


  public void setOrganizationApiKeysUrl(String organizationApiKeysUrl) {
    
    
    
    this.organizationApiKeysUrl = organizationApiKeysUrl;
  }


  public OrganizationProperty1 organizationLiveAccessUrl(String organizationLiveAccessUrl) {
    
    
    
    
    this.organizationLiveAccessUrl = organizationLiveAccessUrl;
    return this;
  }

   /**
   * Link to the resource that enables you to request live access.
   * @return organizationLiveAccessUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/live-access", required = true, value = "Link to the resource that enables you to request live access.")

  public String getOrganizationLiveAccessUrl() {
    return organizationLiveAccessUrl;
  }


  public void setOrganizationLiveAccessUrl(String organizationLiveAccessUrl) {
    
    
    
    this.organizationLiveAccessUrl = organizationLiveAccessUrl;
  }


  public OrganizationProperty1 organizationWebhooksUrl(String organizationWebhooksUrl) {
    
    
    
    
    this.organizationWebhooksUrl = organizationWebhooksUrl;
    return this;
  }

   /**
   * Link to the endpoint which enables webhook creation.
   * @return organizationWebhooksUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/webhooks", required = true, value = "Link to the endpoint which enables webhook creation.")

  public String getOrganizationWebhooksUrl() {
    return organizationWebhooksUrl;
  }


  public void setOrganizationWebhooksUrl(String organizationWebhooksUrl) {
    
    
    
    this.organizationWebhooksUrl = organizationWebhooksUrl;
  }


  public OrganizationProperty1 organizationWorkflowsUrl(String organizationWorkflowsUrl) {
    
    
    
    
    this.organizationWorkflowsUrl = organizationWorkflowsUrl;
    return this;
  }

   /**
   * Link to the onboarding [workflows](http://docs.griffin.com) configured for this [organization](http://docs.griffin.com).
   * @return organizationWorkflowsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/workflows", required = true, value = "Link to the onboarding [workflows](http://docs.griffin.com) configured for this [organization](http://docs.griffin.com).")

  public String getOrganizationWorkflowsUrl() {
    return organizationWorkflowsUrl;
  }


  public void setOrganizationWorkflowsUrl(String organizationWorkflowsUrl) {
    
    
    
    this.organizationWorkflowsUrl = organizationWorkflowsUrl;
  }


  public OrganizationProperty1 organizationBankAccountsUrl(String organizationBankAccountsUrl) {
    
    
    
    
    this.organizationBankAccountsUrl = organizationBankAccountsUrl;
    return this;
  }

   /**
   * Link to the [bank accounts](http://docs.griffin.com) managed by this [organization](http://docs.griffin.com).
   * @return organizationBankAccountsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/bank/accounts", required = true, value = "Link to the [bank accounts](http://docs.griffin.com) managed by this [organization](http://docs.griffin.com).")

  public String getOrganizationBankAccountsUrl() {
    return organizationBankAccountsUrl;
  }


  public void setOrganizationBankAccountsUrl(String organizationBankAccountsUrl) {
    
    
    
    this.organizationBankAccountsUrl = organizationBankAccountsUrl;
  }


  public OrganizationProperty1 availableRoles(List<Role5> availableRoles) {
    
    
    
    
    this.availableRoles = availableRoles;
    return this;
  }

  public OrganizationProperty1 addAvailableRolesItem(Role5 availableRolesItem) {
    this.availableRoles.add(availableRolesItem);
    return this;
  }

   /**
   * The subset of [roles](http://docs.griffin.com) available to [members](http://docs.griffin.com) of this [organization](http://docs.griffin.com).
   * @return availableRoles
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The subset of [roles](http://docs.griffin.com) available to [members](http://docs.griffin.com) of this [organization](http://docs.griffin.com).")

  public List<Role5> getAvailableRoles() {
    return availableRoles;
  }


  public void setAvailableRoles(List<Role5> availableRoles) {
    
    
    
    this.availableRoles = availableRoles;
  }


  public OrganizationProperty1 canDecideOnVerificationsQuestionMark(Boolean canDecideOnVerificationsQuestionMark) {
    
    
    
    
    this.canDecideOnVerificationsQuestionMark = canDecideOnVerificationsQuestionMark;
    return this;
  }

   /**
   * Is this organization able to make manual decisions on verifications?
   * @return canDecideOnVerificationsQuestionMark
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Is this organization able to make manual decisions on verifications?")

  public Boolean getCanDecideOnVerificationsQuestionMark() {
    return canDecideOnVerificationsQuestionMark;
  }


  public void setCanDecideOnVerificationsQuestionMark(Boolean canDecideOnVerificationsQuestionMark) {
    
    
    
    this.canDecideOnVerificationsQuestionMark = canDecideOnVerificationsQuestionMark;
  }


  public OrganizationProperty1 organizationUrl(String organizationUrl) {
    
    
    
    
    this.organizationUrl = organizationUrl;
    return this;
  }

   /**
   * Link to the [organization](http://docs.griffin.com).
   * @return organizationUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA", required = true, value = "Link to the [organization](http://docs.griffin.com).")

  public String getOrganizationUrl() {
    return organizationUrl;
  }


  public void setOrganizationUrl(String organizationUrl) {
    
    
    
    this.organizationUrl = organizationUrl;
  }


  public OrganizationProperty1 organizationIndividualsUrl(String organizationIndividualsUrl) {
    
    
    
    
    this.organizationIndividualsUrl = organizationIndividualsUrl;
    return this;
  }

   /**
   * Get organizationIndividualsUrl
   * @return organizationIndividualsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/individuals", required = true, value = "")

  public String getOrganizationIndividualsUrl() {
    return organizationIndividualsUrl;
  }


  public void setOrganizationIndividualsUrl(String organizationIndividualsUrl) {
    
    
    
    this.organizationIndividualsUrl = organizationIndividualsUrl;
  }


  public OrganizationProperty1 organizationCorporationsUrl(String organizationCorporationsUrl) {
    
    
    
    
    this.organizationCorporationsUrl = organizationCorporationsUrl;
    return this;
  }

   /**
   * Get organizationCorporationsUrl
   * @return organizationCorporationsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/corporations", required = true, value = "")

  public String getOrganizationCorporationsUrl() {
    return organizationCorporationsUrl;
  }


  public void setOrganizationCorporationsUrl(String organizationCorporationsUrl) {
    
    
    
    this.organizationCorporationsUrl = organizationCorporationsUrl;
  }


  public OrganizationProperty1 organizationLegalPersonsUrl(String organizationLegalPersonsUrl) {
    
    
    
    
    this.organizationLegalPersonsUrl = organizationLegalPersonsUrl;
    return this;
  }

   /**
   * Link to the [legal persons](http://docs.griffin.com) grouped under this [organization](http://docs.griffin.com).
   * @return organizationLegalPersonsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/legal-persons", required = true, value = "Link to the [legal persons](http://docs.griffin.com) grouped under this [organization](http://docs.griffin.com).")

  public String getOrganizationLegalPersonsUrl() {
    return organizationLegalPersonsUrl;
  }


  public void setOrganizationLegalPersonsUrl(String organizationLegalPersonsUrl) {
    
    
    
    this.organizationLegalPersonsUrl = organizationLegalPersonsUrl;
  }


  public OrganizationProperty1 organizationEventsUrl(String organizationEventsUrl) {
    
    
    
    
    this.organizationEventsUrl = organizationEventsUrl;
    return this;
  }

   /**
   * Link to the endpoint which lists an organization&#39;s events.
   * @return organizationEventsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/events", required = true, value = "Link to the endpoint which lists an organization's events.")

  public String getOrganizationEventsUrl() {
    return organizationEventsUrl;
  }


  public void setOrganizationEventsUrl(String organizationEventsUrl) {
    
    
    
    this.organizationEventsUrl = organizationEventsUrl;
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
   * @return the OrganizationProperty1 instance itself
   */
  public OrganizationProperty1 putAdditionalProperty(String key, Object value) {
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
    OrganizationProperty1 organizationProperty1 = (OrganizationProperty1) o;
    return Objects.equals(this.ownLegalPersonUrl, organizationProperty1.ownLegalPersonUrl) &&
        Objects.equals(this.organizationMode, organizationProperty1.organizationMode) &&
        Objects.equals(this.organizationMembershipsUrl, organizationProperty1.organizationMembershipsUrl) &&
        Objects.equals(this.organizationInvitationsUrl, organizationProperty1.organizationInvitationsUrl) &&
        Objects.equals(this.organizationOnboardingApplicationsUrl, organizationProperty1.organizationOnboardingApplicationsUrl) &&
        Objects.equals(this.displayName, organizationProperty1.displayName) &&
        Objects.equals(this.organizationApiKeysUrl, organizationProperty1.organizationApiKeysUrl) &&
        Objects.equals(this.organizationLiveAccessUrl, organizationProperty1.organizationLiveAccessUrl) &&
        Objects.equals(this.organizationWebhooksUrl, organizationProperty1.organizationWebhooksUrl) &&
        Objects.equals(this.organizationWorkflowsUrl, organizationProperty1.organizationWorkflowsUrl) &&
        Objects.equals(this.organizationBankAccountsUrl, organizationProperty1.organizationBankAccountsUrl) &&
        Objects.equals(this.availableRoles, organizationProperty1.availableRoles) &&
        Objects.equals(this.canDecideOnVerificationsQuestionMark, organizationProperty1.canDecideOnVerificationsQuestionMark) &&
        Objects.equals(this.organizationUrl, organizationProperty1.organizationUrl) &&
        Objects.equals(this.organizationIndividualsUrl, organizationProperty1.organizationIndividualsUrl) &&
        Objects.equals(this.organizationCorporationsUrl, organizationProperty1.organizationCorporationsUrl) &&
        Objects.equals(this.organizationLegalPersonsUrl, organizationProperty1.organizationLegalPersonsUrl) &&
        Objects.equals(this.organizationEventsUrl, organizationProperty1.organizationEventsUrl)&&
        Objects.equals(this.additionalProperties, organizationProperty1.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownLegalPersonUrl, organizationMode, organizationMembershipsUrl, organizationInvitationsUrl, organizationOnboardingApplicationsUrl, displayName, organizationApiKeysUrl, organizationLiveAccessUrl, organizationWebhooksUrl, organizationWorkflowsUrl, organizationBankAccountsUrl, availableRoles, canDecideOnVerificationsQuestionMark, organizationUrl, organizationIndividualsUrl, organizationCorporationsUrl, organizationLegalPersonsUrl, organizationEventsUrl, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationProperty1 {\n");
    sb.append("    ownLegalPersonUrl: ").append(toIndentedString(ownLegalPersonUrl)).append("\n");
    sb.append("    organizationMode: ").append(toIndentedString(organizationMode)).append("\n");
    sb.append("    organizationMembershipsUrl: ").append(toIndentedString(organizationMembershipsUrl)).append("\n");
    sb.append("    organizationInvitationsUrl: ").append(toIndentedString(organizationInvitationsUrl)).append("\n");
    sb.append("    organizationOnboardingApplicationsUrl: ").append(toIndentedString(organizationOnboardingApplicationsUrl)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    organizationApiKeysUrl: ").append(toIndentedString(organizationApiKeysUrl)).append("\n");
    sb.append("    organizationLiveAccessUrl: ").append(toIndentedString(organizationLiveAccessUrl)).append("\n");
    sb.append("    organizationWebhooksUrl: ").append(toIndentedString(organizationWebhooksUrl)).append("\n");
    sb.append("    organizationWorkflowsUrl: ").append(toIndentedString(organizationWorkflowsUrl)).append("\n");
    sb.append("    organizationBankAccountsUrl: ").append(toIndentedString(organizationBankAccountsUrl)).append("\n");
    sb.append("    availableRoles: ").append(toIndentedString(availableRoles)).append("\n");
    sb.append("    canDecideOnVerificationsQuestionMark: ").append(toIndentedString(canDecideOnVerificationsQuestionMark)).append("\n");
    sb.append("    organizationUrl: ").append(toIndentedString(organizationUrl)).append("\n");
    sb.append("    organizationIndividualsUrl: ").append(toIndentedString(organizationIndividualsUrl)).append("\n");
    sb.append("    organizationCorporationsUrl: ").append(toIndentedString(organizationCorporationsUrl)).append("\n");
    sb.append("    organizationLegalPersonsUrl: ").append(toIndentedString(organizationLegalPersonsUrl)).append("\n");
    sb.append("    organizationEventsUrl: ").append(toIndentedString(organizationEventsUrl)).append("\n");
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
    openapiFields.add("own-legal-person-url");
    openapiFields.add("organization-mode");
    openapiFields.add("organization-memberships-url");
    openapiFields.add("organization-invitations-url");
    openapiFields.add("organization-onboarding-applications-url");
    openapiFields.add("display-name");
    openapiFields.add("organization-api-keys-url");
    openapiFields.add("organization-live-access-url");
    openapiFields.add("organization-webhooks-url");
    openapiFields.add("organization-workflows-url");
    openapiFields.add("organization-bank-accounts-url");
    openapiFields.add("available-roles");
    openapiFields.add("can-decide-on-verifications?");
    openapiFields.add("organization-url");
    openapiFields.add("organization-individuals-url");
    openapiFields.add("organization-corporations-url");
    openapiFields.add("organization-legal-persons-url");
    openapiFields.add("organization-events-url");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("own-legal-person-url");
    openapiRequiredFields.add("organization-mode");
    openapiRequiredFields.add("organization-memberships-url");
    openapiRequiredFields.add("organization-invitations-url");
    openapiRequiredFields.add("display-name");
    openapiRequiredFields.add("organization-api-keys-url");
    openapiRequiredFields.add("organization-live-access-url");
    openapiRequiredFields.add("organization-webhooks-url");
    openapiRequiredFields.add("organization-workflows-url");
    openapiRequiredFields.add("organization-bank-accounts-url");
    openapiRequiredFields.add("available-roles");
    openapiRequiredFields.add("can-decide-on-verifications?");
    openapiRequiredFields.add("organization-url");
    openapiRequiredFields.add("organization-individuals-url");
    openapiRequiredFields.add("organization-corporations-url");
    openapiRequiredFields.add("organization-legal-persons-url");
    openapiRequiredFields.add("organization-events-url");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to OrganizationProperty1
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!OrganizationProperty1.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in OrganizationProperty1 is not found in the empty JSON string", OrganizationProperty1.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : OrganizationProperty1.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("own-legal-person-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `own-legal-person-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("own-legal-person-url").toString()));
      }
      if (!jsonObj.get("organization-mode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-mode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-mode").toString()));
      }
      if (!jsonObj.get("organization-memberships-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-memberships-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-memberships-url").toString()));
      }
      if (!jsonObj.get("organization-invitations-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-invitations-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-invitations-url").toString()));
      }
      if ((jsonObj.get("organization-onboarding-applications-url") != null && !jsonObj.get("organization-onboarding-applications-url").isJsonNull()) && !jsonObj.get("organization-onboarding-applications-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-onboarding-applications-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-onboarding-applications-url").toString()));
      }
      if (!jsonObj.get("display-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `display-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("display-name").toString()));
      }
      if (!jsonObj.get("organization-api-keys-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-api-keys-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-api-keys-url").toString()));
      }
      if (!jsonObj.get("organization-live-access-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-live-access-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-live-access-url").toString()));
      }
      if (!jsonObj.get("organization-webhooks-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-webhooks-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-webhooks-url").toString()));
      }
      if (!jsonObj.get("organization-workflows-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-workflows-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-workflows-url").toString()));
      }
      if (!jsonObj.get("organization-bank-accounts-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-bank-accounts-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-bank-accounts-url").toString()));
      }
      // ensure the json data is an array
      if (!jsonObj.get("available-roles").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `available-roles` to be an array in the JSON string but got `%s`", jsonObj.get("available-roles").toString()));
      }

      JsonArray jsonArrayavailableRoles = jsonObj.getAsJsonArray("available-roles");
      // validate the required field `available-roles` (array)
      for (int i = 0; i < jsonArrayavailableRoles.size(); i++) {
        Role5.validateJsonObject(jsonArrayavailableRoles.get(i).getAsJsonObject());
      };
      if (!jsonObj.get("organization-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-url").toString()));
      }
      if (!jsonObj.get("organization-individuals-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-individuals-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-individuals-url").toString()));
      }
      if (!jsonObj.get("organization-corporations-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-corporations-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-corporations-url").toString()));
      }
      if (!jsonObj.get("organization-legal-persons-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-legal-persons-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-legal-persons-url").toString()));
      }
      if (!jsonObj.get("organization-events-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-events-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-events-url").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!OrganizationProperty1.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'OrganizationProperty1' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<OrganizationProperty1> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(OrganizationProperty1.class));

       return (TypeAdapter<T>) new TypeAdapter<OrganizationProperty1>() {
           @Override
           public void write(JsonWriter out, OrganizationProperty1 value) throws IOException {
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
           public OrganizationProperty1 read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             OrganizationProperty1 instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of OrganizationProperty1 given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of OrganizationProperty1
  * @throws IOException if the JSON string is invalid with respect to OrganizationProperty1
  */
  public static OrganizationProperty1 fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, OrganizationProperty1.class);
  }

 /**
  * Convert an instance of OrganizationProperty1 to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

