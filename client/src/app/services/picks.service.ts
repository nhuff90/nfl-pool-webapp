import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class PicksService {
  constructor(private http: HttpClient) {}



  getPicksByWeek(week): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/picks/' + week);
  }

  getWeeklyStats(week): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/picks/weeklyStats/' + week);
  }

  getAnnualStats(): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/picks/annualStats/');
  }

  getColumns(): string[]{
    return ["Game", "Progress", "Line", "Risked", "To Win", "Covering?"]};

  getCurrentWeek() {
    return 3;
  }
}
