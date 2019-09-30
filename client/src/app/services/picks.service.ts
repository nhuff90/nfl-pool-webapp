import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class PicksService {
  constructor(private http: HttpClient) {}



  getPicksByWeek(week): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/picks/' + week);
    // return this.http.get('http://localhost:8090/picks/' + week);
  }

  getParleyPicksByWeek(week): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/picks/parley/' + week);
    // return this.http.get('http://localhost:8090/picks/parley/' + week);
  }

  getWeeklyStats(week): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/picks/weeklyStats/' + week);
    // return this.http.get('http://localhost:8090/picks/weeklyStats/' + week);
  }

  getAnnualStats(): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/picks/annualStats/');
    // return this.http.get('http://localhost:8090/picks/annualStats/');
  }

  getColumns(): string[]{
    return ["Game", "Progress", "Line", "Risked", "To Win", "Covering?"]};

  getCurrentWeek() {
    return 4;
  }
}
