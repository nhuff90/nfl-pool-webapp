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
  columns: string[];
  record: string;
  overallRecord: string;

  activeGames: number;

  constructor(private atService: PicksService, private gameService: GameService) {
  }

  ngOnInit() {
    this.selectedWeek = this.atService.getCurrentWeek();
    this.columns = this.atService.getColumns();
    this.picksWithGame = this.atService.getPicksByWeek(this.selectedWeek);
    this.gameService.getActiveGamesByWeek(this.selectedWeek).subscribe(data => {this.activeGames = data.lengthFromService});
    this.atService.getRecordWeek(this.selectedWeek).subscribe(res => {
      this.record = res;
    });
    this.atService.getOverallRecordWeek().subscribe(res => {
      this.overallRecord = res;
    });
  }
}
