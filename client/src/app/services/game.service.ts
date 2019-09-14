import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class GameService {

  constructor(private http: HttpClient) {}

  getGamesByWeek(week): Observable<any> {
    return this.http.get('http://ec2-18-224-61-229.us-east-2.compute.amazonaws.com/games/' + week);
  }

  getActiveGamesByWeek(week): Observable<any> {
    return this.http.get('http://ec2-18-224-61-229.us-east-2.compute.amazonaws.com/games/active/' + week);
  }

  getColumns(): string[]{
    return ["Home Team", "Home Score", "vs.", "Away Team", "Away Score"]};

  getCurrentWeek() {
    return 1;
  }
}
