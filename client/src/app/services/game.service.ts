import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class GameService {

  constructor(private http: HttpClient) {}

  getGamesByWeek(week): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/games/' + week);
  }

  getActiveGamesByWeek(week): Observable<any> {
    return this.http.get('http://nfl.natehuff.info/games/active/' + week);
  }

  getCurrentWeek() {
    return 4;
  }
}
