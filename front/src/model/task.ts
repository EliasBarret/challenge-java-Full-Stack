export interface listTasks{
  id:number;
}

export class Task {
    _id: number;
    description: string;
    sn_done: string;
    item:listTasks[];
  }