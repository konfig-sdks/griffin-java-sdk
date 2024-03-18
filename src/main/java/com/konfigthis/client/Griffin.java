package com.konfigthis.client;

import com.konfigthis.client.api.ApiKeysApi;
import com.konfigthis.client.api.BankAccountsApi;
import com.konfigthis.client.api.ClaimsApi;
import com.konfigthis.client.api.CompaniesHouseApi;
import com.konfigthis.client.api.ConnectivityApi;
import com.konfigthis.client.api.DecisionsApi;
import com.konfigthis.client.api.EventsApi;
import com.konfigthis.client.api.InvitationsApi;
import com.konfigthis.client.api.LegalPersonHistoryApi;
import com.konfigthis.client.api.LegalPersonsApi;
import com.konfigthis.client.api.MembershipsApi;
import com.konfigthis.client.api.NavigationApi;
import com.konfigthis.client.api.OrganizationsApi;
import com.konfigthis.client.api.PayeesApi;
import com.konfigthis.client.api.PaymentsApi;
import com.konfigthis.client.api.PooledAccountMembershipApi;
import com.konfigthis.client.api.RelianceOnboardingApi;
import com.konfigthis.client.api.RolesApi;
import com.konfigthis.client.api.TransactionsApi;
import com.konfigthis.client.api.UsersApi;
import com.konfigthis.client.api.VerificationsApi;
import com.konfigthis.client.api.WebhooksApi;
import com.konfigthis.client.api.WorkflowsApi;

public class Griffin {
    private ApiClient apiClient;
    public final ApiKeysApi apiKeys;
    public final BankAccountsApi bankAccounts;
    public final ClaimsApi claims;
    public final CompaniesHouseApi companiesHouse;
    public final ConnectivityApi connectivity;
    public final DecisionsApi decisions;
    public final EventsApi events;
    public final InvitationsApi invitations;
    public final LegalPersonHistoryApi legalPersonHistory;
    public final LegalPersonsApi legalPersons;
    public final MembershipsApi memberships;
    public final NavigationApi navigation;
    public final OrganizationsApi organizations;
    public final PayeesApi payees;
    public final PaymentsApi payments;
    public final PooledAccountMembershipApi pooledAccountMembership;
    public final RelianceOnboardingApi relianceOnboarding;
    public final RolesApi roles;
    public final TransactionsApi transactions;
    public final UsersApi users;
    public final VerificationsApi verifications;
    public final WebhooksApi webhooks;
    public final WorkflowsApi workflows;

    public Griffin() {
        this(null);
    }

    public Griffin(Configuration configuration) {
        this.apiClient = new ApiClient(null, configuration);
        this.apiKeys = new ApiKeysApi(this.apiClient);
        this.bankAccounts = new BankAccountsApi(this.apiClient);
        this.claims = new ClaimsApi(this.apiClient);
        this.companiesHouse = new CompaniesHouseApi(this.apiClient);
        this.connectivity = new ConnectivityApi(this.apiClient);
        this.decisions = new DecisionsApi(this.apiClient);
        this.events = new EventsApi(this.apiClient);
        this.invitations = new InvitationsApi(this.apiClient);
        this.legalPersonHistory = new LegalPersonHistoryApi(this.apiClient);
        this.legalPersons = new LegalPersonsApi(this.apiClient);
        this.memberships = new MembershipsApi(this.apiClient);
        this.navigation = new NavigationApi(this.apiClient);
        this.organizations = new OrganizationsApi(this.apiClient);
        this.payees = new PayeesApi(this.apiClient);
        this.payments = new PaymentsApi(this.apiClient);
        this.pooledAccountMembership = new PooledAccountMembershipApi(this.apiClient);
        this.relianceOnboarding = new RelianceOnboardingApi(this.apiClient);
        this.roles = new RolesApi(this.apiClient);
        this.transactions = new TransactionsApi(this.apiClient);
        this.users = new UsersApi(this.apiClient);
        this.verifications = new VerificationsApi(this.apiClient);
        this.webhooks = new WebhooksApi(this.apiClient);
        this.workflows = new WorkflowsApi(this.apiClient);
    }

}
