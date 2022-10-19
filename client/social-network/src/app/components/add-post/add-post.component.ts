import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from 'src/app/model/post.model';
import { User } from 'src/app/model/user.model';
import { AppService } from 'src/app/services/app.service';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css'],
})
export class AddPostComponent implements OnInit {
  public newPost: Post;
  public user!: User;

  @Output() addPostOnEvent: EventEmitter<Post> = new EventEmitter();
  @Output() resetPostOnEvent: EventEmitter<Post> = new EventEmitter();

  constructor(private appService: AppService, private router: Router) {
    this.newPost = new Post({
      id: -1,
      user: JSON.parse(window.localStorage['loggedUser']),
      time: new Date(),
      content: '',
    });
  }

  ngOnInit(): void {
    this.getUser();
  }

  // addPost(): void {
  //   console.log(this.newPost);

  //   this.addPostOnEvent.emit(this.newPost);
  //   this.newPost = {
  //     id: -1,
  //     user: {
  //       id: -1,
  //       firstName: '',
  //       lastName: '',
  //       username: '',
  //     },
  //     time: new Date(),
  //     content: '',
  //   };

  //   this.router.navigate(['/home']);
  // }

   addPost(){
    this.appService.addPost(this.newPost).subscribe((response) => {
      this.newPost = response;
      this.router.navigate(['/home']);
    })
         
  }



  resetPost(): void {

    this.newPost = {
      id: -1,
      user: {
        id: -1,
        firstName: '',
        lastName: '',
        username: '',
      },
      time: new Date(),
      content: '',
    };
    this.resetPostOnEvent.emit(this.newPost);
    this.router.navigate(['/home']);

  }

  getUser(): void {
    this.user = JSON.parse(window.localStorage['loggedUser']);
  }
}
