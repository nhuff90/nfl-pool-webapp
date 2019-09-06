import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class PicksService {

  constructor(private http: HttpClient) {}



  getPicksByWeek(week): Observable<any> {
    return this.http.get('http://localhost:8090/picks/' + week);
  }

  getRecordWeek(week): Observable<string> {
    return this.http.get('http://localhost:8090/picks/record/' + week, { responseType: 'text' });
  }

  getOverallRecordWeek(): Observable<string> {
    return this.http.get('http://localhost:8090/picks/record/', { responseType: 'text' });
  }

  getColumns(): string[]{
    return ["Home Team", "Home Score", "vs.", "Away Team", "Away Score", "Line", "Game Progress", "Covering?"]};

  getCurrentWeek() {
    return 1;
  }

}
