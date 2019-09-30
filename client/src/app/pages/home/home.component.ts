/**
 * Created by andrew.yang on 5/18/2017.
 */
import {Component, OnInit} from "@angular/core";
import {PicksService} from "../../services/picks.service";
import {Observable} from "rxjs";
import {GameService} from "../../services/game.service";

@Component({
    selector: 'home',
  templateUrl: './home.component.html',
  providers: [PicksService, GameService]
})
export class HomeComponent implements OnInit {

  selectedWeek: number;
  picksWithGame: Observable<any[]>;
  parleyPicksWithGame: Observable<any[]>;
  columns: string[];
  weeklyStats: Observable<any[]>;
  annualStats: Observable<any[]>;

  activeGames: number;

  weeks = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17];

  constructor(private atService: PicksService, private gameService: GameService) {
  }
  ngOnInit() {
    this.selectedWeek = this.atService.getCurrentWeek();
    this.columns = this.atService.getColumns();
    this.picksWithGame = this.atService.getPicksByWeek(this.selectedWeek);
    this.parleyPicksWithGame = this.atService.getParleyPicksByWeek(this.selectedWeek);
    this.gameService.getActiveGamesByWeek(this.selectedWeek).subscribe(data => {this.activeGames = data.lengthFromService});
    this.atService.getWeeklyStats(this.selectedWeek).subscribe(res => {
      this.weeklyStats = res;
    });
    this.atService.getAnnualStats().subscribe(res => {
      this.annualStats = res;
    });
  }

  updatePicksByWeek(week) {
    console.log('home updatePicksByWeek called.');
    this.selectedWeek = week;
    this.picksWithGame = this.atService.getPicksByWeek(this.selectedWeek);
    this.parleyPicksWithGame = this.atService.getParleyPicksByWeek(this.selectedWeek);
    this.gameService.getActiveGamesByWeek(this.selectedWeek).subscribe(data => {this.activeGames = data.lengthFromService});
    this.atService.getWeeklyStats(this.selectedWeek).subscribe(res => {
      this.weeklyStats = res;
    });
    this.atService.getAnnualStats().subscribe(res => {
      this.annualStats = res;
    });
  }

  getCurrentWeek() {
    return this.gameService.getCurrentWeek();
  }
}
