import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TasksComponent } from './tasks/tasks.component';
import { TaskDetailComponent } from './task-detail/task-detail.component';
import { TaskNewComponent } from './task-new/task-new.component';
import { TaskEditComponent } from './task-edit/task-edit.component';


const routes: Routes = [
  {
    path: 'task',
    component: TasksComponent,
    data: { title: 'Tarefas' }
  },
  {
    path: 'task-detail/:id',
    component: TaskDetailComponent,
    data: { title: 'Detalhe Tarefa' }
  },
  {
    path: 'task-new',
    component: TaskNewComponent,
    data: { title: 'Adicionar Tarefa' }
  },
  {
    path: 'task-edit/:id',
    component: TaskEditComponent,
    data: { title: 'Editar o Tarefa' }
  },
  { path: '',
    redirectTo: '/tasks',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
