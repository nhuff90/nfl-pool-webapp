import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class PicksService {
  week = 1;
  constructor(private http: HttpClient) {}



  getPicksByWeek(week): Observable<any> {
    return this.http.get('http://ec2-18-224-61-229.us-east-2.compute.amazonaws.com/picks/' + week);
  }

  getRecordWeek(week): Observable<any> {
    return this.http.get('http://ec2-18-224-61-229.us-east-2.compute.amazonaws.com/picks/record/' + week);
  }

  getOverallRecordWeek(): Observable<any> {
    return this.http.get('http://ec2-18-224-61-229.us-east-2.compute.amazonaws.com/picks/record/');
  }

  getColumns(): string[]{
    return ["Home Team", "Home Score", "vs.", "Away Team", "Away Score", "Line", "Risked", "To Win", "Game Progress", "Covering?"]};

  getCurrentWeek() {
    return this.week;
  }
}
