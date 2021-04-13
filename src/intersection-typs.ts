class Grid {
    width: number = 0;
    height: number = 0;
    weight: number = 0;
    padding: number = 0;
}

class Margin {
    left: number = 0;
    top: number = 0;
    width: number = 10;
    height: number = 20;
    weight: number | string = '1';
    padding?: number;
}

function consolidatedGrid(grid: Grid, margin: Margin): Grid & Margin {
    let consolidatedGrid = <Grid & Margin>{};
    consolidatedGrid.width = grid.width + margin.width;
    consolidatedGrid.height = grid.height + margin.height;
    consolidatedGrid.left = margin.left;
    consolidatedGrid.left = margin.left;
    consolidatedGrid.weight = grid.weight + Number(margin.weight);
    consolidatedGrid.padding = margin.padding ? margin.padding : grid.padding;
    return consolidatedGrid;
}
