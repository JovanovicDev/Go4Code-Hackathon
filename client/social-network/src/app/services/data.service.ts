import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private commentSource = new BehaviorSubject<number>(-1);
  idForComment = this.commentSource.asObservable();

  private viewSource = new BehaviorSubject<number>(-1);
  view = this.viewSource.asObservable();

  private loginSource = new BehaviorSubject<boolean>(false);
  login = this.loginSource.asObservable();

  private updateTable = new BehaviorSubject<boolean>(false);
  update = this.updateTable.asObservable();

  constructor() { }

  changePostForComment(id: number) {
    this.commentSource.next(id)
  }

  setPostForView(val: number) {
    this.viewSource.next(val);
  }

  changeLoginStatus(val: boolean) {
    this.loginSource.next(val);
  }

  updateTableStatus(val: boolean) {
    this.updateTable.next(val);
  }

}
