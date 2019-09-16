import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {GameService} from "../../services/game.service";

@Component({
    selector: 'app-others',
    templateUrl: './others.component.html',
  providers: [GameService]
})
export class OthersComponent implements OnInit {

  selectedWeek: number;
  games: Observable<any[]>;
  columns: string[];

  constructor(private atService: GameService) {
  }

  ngOnInit() {
    this.selectedWeek = this.atService.getCurrentWeek();
    this.games = this.atService.getGamesByWeek(this.selectedWeek);
    this.games = this.atService.getActiveGamesByWeek(this.selectedWeek);
  }
}
