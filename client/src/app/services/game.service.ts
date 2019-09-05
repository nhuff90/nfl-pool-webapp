import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class GameService {

  constructor(private http: HttpClient) {}

  getGamesByWeek(week): Observable<any> {
    return this.http.get('http://localhost:8090/games/' + week);
  }

  getActiveGamesByWeek(week): Observable<any> {
    return this.http.get('http://localhost:8090/games/active/' + week);
  }

  getColumns(): string[]{
    return ["Home Team", "Home Score", "vs.", "Away Team", "Away Score"]};

  getCurrentWeek() {
    return 2;
  }
}
