import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClient, HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { NavbarComponent } from './navbar/navbar.component';
import { RegistracijaComponent } from './modules/home/register_users/registracija.component';
import {RouterModule} from '@angular/router';
import { AgmCoreModule} from '@agm/core';
import { AdvertisementComponent } from './modules/advertisement/advertisement.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AdvertisementService } from './services/advertisement.service/advertisement.service';
import {
  AdvertisementListComponent,
  ChangeDiscountDialogComponent,
  ImagesDialogComponent
} from './modules/advertisement/advertisement-list/advertisement-list.component';
import { HomepageComponent } from './modules/home/homepage/homepage.component';
import { LoginComponent } from './modules/home/login/login.component';
import { ShoppingCartComponent } from './modules/shopping-cart/shopping-cart.component';
import { ShopingCartService } from './modules/shopping-cart/shoping-cart.service';
import {MatFormFieldModule} from '@angular/material';
import { AdministratorComponent } from './modules/administrator/home/administrator.component';
import { ZahteviRegistracijaComponent } from './modules/administrator/zahtevi-registracija/zahtevi-registracija.component';
import { CommonModule } from '@angular/common';
import { RepresentRequestsComponent } from './modules/repsresent-requests/repsresent-requests.component';
import { RepresentRequestsService } from './modules/repsresent-requests/represent-requests.service';
import { RegisterConfirmComponent } from './modules/home/register-confirm/register-confirm.component';
import { PorukeComponent } from './modules/poruke/poruke.component';
import { PorukeService } from './modules/poruke/poruke.component.service';
import { ConversationComponent } from './modules/conversation/conversation.component';
import { ConversationService } from './modules/conversation/conversation.service';
import { AgentRegisterComponent } from './modules/administrator/agent-register/agent-register.component';
import { IzmenaLozinkeComponent } from './modules/shared/izmena-lozinke/izmena-lozinke.component';
import { HistoryComponent } from './modules/history/history.component';
import { HistoryService } from './modules/history/history.component.service';
import { CreateReportComponent } from './modules/agent/create-report/create-report.component';
import { AgentsCarsComponent } from './modules/agent/agents-cars/agents-cars.component';
import {CarDTO} from './dtos/car-dto';
import {StatisticsComponent} from './modules/statistics/statistics.component';
import {MatDialogModule} from '@angular/material/dialog';
import { UserManagmentComponent } from './modules/administrator/user-managment/user-managment.component';
import {AgentComponent} from './modules/agent/home/agent.component';
import { SifrarnikComponent } from './modules/administrator/sifrarnik/sifrarnik.component';
import {EndUserService} from './services/EndUserService/end-user.service';
import { AdvertisementDetailsComponent } from './modules/advertisement/advertisement-details/advertisement-details.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatInput, MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { AgentsAdvertisementsComponent } from './modules/agent/agents-advertisements/agents-advertisements.component';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from "@angular/material/select";
import { AuthInterceptor } from './services/httpInterceptor.service';
import { ReserveComponent } from './modules/reserve/reserve.component';
import { CommentManagementComponent } from './modules/administrator/comment-management/comment-management.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    RegistracijaComponent,
    AdvertisementComponent,
    LoginComponent,
    HomepageComponent,
    AdvertisementListComponent,
    AdministratorComponent,
    ZahteviRegistracijaComponent,
    ShoppingCartComponent,
    RepresentRequestsComponent,
    RegisterConfirmComponent,
    AgentRegisterComponent,
    IzmenaLozinkeComponent,
    PorukeComponent,
    ConversationComponent,
    AgentRegisterComponent,
    HistoryComponent,
    AgentComponent,
    CreateReportComponent,
    AgentsCarsComponent,
    UserManagmentComponent,
    SifrarnikComponent,
    StatisticsComponent,
    AdvertisementDetailsComponent,
    ChangeDiscountDialogComponent,
    ImagesDialogComponent,
    AgentsAdvertisementsComponent,
    ReserveComponent,
    CommentManagementComponent
],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    CommonModule,
    RouterModule.forRoot([
      {path: 'registrationConfirm.html', component: RegisterConfirmComponent},
      {path: 'izmenaLozinke', component: IzmenaLozinkeComponent},
      {path: 'sifrarnik', component: SifrarnikComponent},
      {path: 'report/:id', component: CreateReportComponent},
      {path: '', component: RegistracijaComponent},
      {path: 'agent', component: AgentComponent},
      {path: 'homepage', component: HomepageComponent},
      {path: 'app-advertisement', component: AdvertisementComponent},
      {path: 'advertisement-list', component: AdvertisementListComponent},
      {path: 'administrator', component: AdministratorComponent},
      {path: 'shoppingCart', component: ShoppingCartComponent},
      {path: 'requests', component: RepresentRequestsComponent},
      {path: 'inbox', component: PorukeComponent},
      {path: 'conversation/:id', component: ConversationComponent},
      {path: 'history', component: HistoryComponent},
      {path: 'login', component: LoginComponent},
      {path: 'register', component: RegistracijaComponent},
      {path: 'conversation/:id', component: ConversationComponent},
      {path: 'statistics', component: StatisticsComponent},
      {path: 'advertisement-details/:id', component: AdvertisementDetailsComponent},
      {path: 'reserve', component: ReserveComponent}
    ]),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBcBUQxfS6JldNG0Ltoju5YxE_0-CKJsu4',
      libraries: ['places']
    }),
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatDialogModule,
    MatTooltipModule,
    MatInputModule,
    MatButtonModule,
    MatRadioModule,
    MatSelectModule

  ],
  exports: [RouterModule],
  providers: [AdvertisementService,
              ShopingCartService,
              RepresentRequestsService,
              PorukeService,
              ConversationService,
              HistoryService,
              EndUserService,
            //  {
             //   provide:HTTP_INTERCEPTORS,
            //    useClass: AuthInterceptor,
            //    multi:true
            //  }
  ],
  bootstrap: [AppComponent],
  entryComponents: [ChangeDiscountDialogComponent, ImagesDialogComponent]

})
export class AppModule { }
