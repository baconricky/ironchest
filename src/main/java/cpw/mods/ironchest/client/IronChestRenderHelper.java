/*******************************************************************************
 * Copyright (c) 2012 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors:
 *     cpw - initial API and implementation
 ******************************************************************************/
package cpw.mods.ironchest.client;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

import cpw.mods.ironchest.IronChest;
import cpw.mods.ironchest.IronChestType;
import cpw.mods.ironchest.TileEntityIronChest;

public class IronChestRenderHelper extends TileEntityItemStackRenderer
{
    private Map<Integer, TileEntityIronChest> itemRenders = Maps.newHashMap();

    public IronChestRenderHelper()
    {
        for (IronChestType typ : IronChestType.values())
        {
            itemRenders.put(typ.ordinal(), (TileEntityIronChest) IronChest.ironChestBlock.createNewTileEntity(null, typ.ordinal()));
        }
    }

    @Override
    public void renderByItem(ItemStack itemStack)
    {
        Block block = Block.getBlockFromItem(itemStack.getItem());
        
        if (block == IronChest.ironChestBlock)
        {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(itemRenders.get(itemStack.getMetadata()), 0.0D, 0.0D, 0.0D, 0.0F);
        }
        else
        {
            super.renderByItem(itemStack);
        }
    }
}
