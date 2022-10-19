import { Component, OnInit, Input } from '@angular/core';
import { Post } from 'src/app/model/post.model';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  loggedIn: boolean;
  @Input() post: Post;

  constructor(private dataService: DataService) { 
    this.post = {
      id: -1,
      user: null,
      time: new Date(),
      content: ''
      }
    this.loggedIn = false;
  }

  ngOnInit(): void {
    if(window.localStorage.getItem('loggedUser') != null){
      this.loggedIn = true;
      this.dataService.changeLoginStatus(true);
    } else {
      this.loggedIn = false;
    }
    this.dataService.login.subscribe(val => {
      this.loggedIn = val;
    })
  }

}
