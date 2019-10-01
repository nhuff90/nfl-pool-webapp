import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class GameService {

  constructor(private http: HttpClient) {}

  getGamesByWeek(week): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/games/' + week);
    // return this.http.get('http://localhost:8090/games/' + week);
  }

  getActiveGamesByWeek(week): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/games/active/' + week);
    // return this.http.get('http://localhost:8090/games/active/' + week);
  }

  getCurrentWeek() {
    return 4;
  }
}
