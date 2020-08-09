import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { ListTaskApiService } from 'src/app/service/list-task-api.service';
import { ListTask } from 'src/model/listTask';
 
@Component({
  selector: 'app-list-task-detail',
  templateUrl: './list-task-detail.component.html',
  styleUrls: ['./list-task-detail.component.scss']
})
export class ListTaskDetailComponent implements OnInit {
  listTask: ListTask = { id:null, description: '', item:null};
 
  isLoadingResults = true;
  constructor(private router: Router, private route: ActivatedRoute, private api: ListTaskApiService) { }


  ngOnInit(): void {
    this.getListTask(this.route.snapshot.params['id']);
   
  }

  getListTask(id) {
    this.api.getListTask(id)
      .subscribe(data => {
        this.listTask = data;
        console.log(this.listTask);
        this.isLoadingResults = false;
      });
  }

  
 /* deleteTask(id) {
    this.isLoadingResults = true;
    this.api.deleteTask(id)
      .subscribe(res => {
          this.isLoadingResults = false;
          this.router.navigate(['/produtos']);
        }, (err) => {
          console.log(err);
          this.isLoadingResults = false;
        }
      );
  }*/
}
