import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class PicksService {
  constructor(private http: HttpClient) {}



  getPicksByWeek(week): Observable<any> {
    return this.http.get('http://ec2-18-224-61-229.us-east-2.compute.amazonaws.com/picks/' + week);
  }

  getWeeklyStats(week): Observable<any> {
    return this.http.get('http://ec2-18-224-61-229.us-east-2.compute.amazonaws.com/picks/weeklyStats/' + week);
  }

  getAnnualStats(): Observable<any> {
    return this.http.get('http://ec2-18-224-61-229.us-east-2.compute.amazonaws.com/picks/annualStats/');
  }

  getColumns(): string[]{
    return ["Home Team", "Home Score", "Away Team", "Away Score", "Line", "Risked", "To Win", "Covering?"]};

  getCurrentWeek() {
    return 2;
  }
}
