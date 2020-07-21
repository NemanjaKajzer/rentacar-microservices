import { DataSource } from '@angular/cdk/collections';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { map } from 'rxjs/operators';
import { Observable, of as observableOf, merge } from 'rxjs';
import {Advertisement} from '../../../model/advertisement';
import {FuelType} from '../../../enums/fuelType';
import {TransmissionType} from '../../../enums/transmissionType';
import {CarClass} from '../../../enums/carClass';
import {CarDetails} from '../../../model/car-details';

// TODO: Replace this with your own data model type
export interface AdvertisementListItem {
  name: string;
  model: string;
  brand: string;
  fuelType: string;
  transType: string;
  carClass: string;
  travelled: number;
  price: number;
  carSeats: number;

}

// TODO: replace this with real data from your application
const EXAMPLE_DATA: AdvertisementListItem[] = [
];

/**
 * Data source for the AdvertisementList view. This class should
 * encapsulate all logic for fetching and manipulating the displayed data
 * (including sorting, pagination, and filtering).
 */
export class AdvertisementListDataSource extends DataSource<AdvertisementListItem> {
  data: Advertisement[];
  paginator: MatPaginator;
  sort: MatSort;

  constructor(advertisements: Array<Advertisement>) {
    super();
    this.data = advertisements;
  }

  /**
   * Connect this data source to the table. The table will only update when
   * the returned stream emits new items.
   * @returns A stream of the items to be rendered.
   */
  connect(): Observable<AdvertisementListItem[]> {
    // Combine everything that affects the rendered data into one update
    // stream for the data-table to consume.
    const dataMutations = [
      observableOf(this.data),
      this.paginator.page,
      this.sort.sortChange
    ];

    return merge(...dataMutations).pipe(map(() => {
      return this.getPagedData(this.getSortedData([...this.data]));
    }));
  }

  /**
   *  Called when the table is being destroyed. Use this function, to clean up
   * any open connections or free any held resources that were set up during connect.
   */
  disconnect() {}

  /**
   * Paginate the data (client-side). If you're using server-side pagination,
   * this would be replaced by requesting the appropriate data from the server.
   */
  private getPagedData(data: AdvertisementListItem[]) {
    const startIndex = this.paginator.pageIndex * this.paginator.pageSize;
    return data.splice(startIndex, this.paginator.pageSize);
  }

  /**
   * Sort the data (client-side). If you're using server-side sorting,
   * this would be replaced by requesting the appropriate data from the server.
   */
  private getSortedData(data: AdvertisementListItem[]) {
    if (!this.sort.active || this.sort.direction === '') {
      return data;
    }

    return data.sort((a, b) => {
      const isAsc = this.sort.direction === 'asc';
      switch (this.sort.active) {
        case 'name': return compare(a.name, b.name, isAsc);
        case 'model': return compare(a.model, b.model, isAsc);
        case 'brand': return compare(a.brand, b.brand, isAsc);
        case 'fuelType': return compare(a.fuelType, b.fuelType, isAsc);
        case 'transmissionType': return compare(a.transType, b.transType, isAsc);
        case 'carClass': return compare(a.carClass, b.carClass, isAsc);
        case 'travelled': return compare(a.travelled, b.travelled, isAsc);
        case 'price': return compare(a.price, b.price, isAsc);
        case 'carSeats': return compare(a.carSeats, b.carSeats, isAsc);

        default: return 0;
      }
    });
  }
}

/** Simple sort comparator for example ID/Name columns (for client-side sorting). */
function compare(a, b, isAsc) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
